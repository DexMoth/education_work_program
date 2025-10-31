package org.work_program.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.AuthDto;
import org.work_program.dtos.VerifyCodeDto;
import org.work_program.models.TeacherModel;
import org.work_program.repositories.TeacherRepository;
import org.work_program.services.EmailService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(Constants.API_URL + "/auth")
@SessionAttributes("teacher")
public class AuthController {
    private final TeacherRepository teacherRepository;
    private final EmailService emailService;
    //хранилище для кодов
    private final Map<String, VerificationData> verificationCodes = new ConcurrentHashMap<>();

    public AuthController(TeacherRepository teacherRepository, EmailService emailService) {
        this.teacherRepository = teacherRepository;
        this.emailService = emailService;
    }

    //для хранения о верификации
    private static class VerificationData {
        String code;
        LocalDateTime expiresAt;
        String method;

        VerificationData(String code, LocalDateTime expiresAt, String method) {
            this.code = code;
            this.expiresAt = expiresAt;
            this.method = method;
        }

        boolean isValid() {
            return LocalDateTime.now().isBefore(expiresAt);
        }
    }

    // Вход
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto dto, HttpSession session) {
        TeacherModel teacher = teacherRepository.findByLoginIgnoreCase(dto.getLogin())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        if (!teacher.getPassword().equals(dto.getPassword())) {
            return ResponseEntity.badRequest().body("Неверный пароль");
        }

        // сохраняем пользователя
        session.setAttribute("teacher", teacher);
        return ResponseEntity.ok("Вход выполнен");
    }

    // Запрос кода верификации
    @PostMapping("/request-code")
    public ResponseEntity<?> requestVerificationCode(@RequestBody Map<String, String> request, HttpSession session) {
        TeacherModel teacher = (TeacherModel) session.getAttribute("teacher");
        if (teacher == null) {
            return ResponseEntity.status(401).body("Не авторизован");
        }

        String method = request.get("method");
        if (!"sms".equals(method) && !"email".equals(method)) {
            return ResponseEntity.badRequest().body("Неверный метод верификации");
        }

        // генерируем
        String code = generateVerificationCode();
        LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(2); // Код действителен 2 минуты

        // сохраняем код в хранилище
        String sessionKey = session.getId();
        verificationCodes.put(sessionKey, new VerificationData(code, expiresAt, method));

        // отправка email
        emailService.sendEmail(teacher.getEmail(), "Код подтверждения", "Код подтверждения: " + code);
        System.out.println("Email отправлен на " + teacher.getEmail());


        Map<String, Object> response = new HashMap<>();
        response.put("message", "Код отправлен");
        response.put("method", method);
        response.put("expires_in", "2 минуты");

        return ResponseEntity.ok(response);
    }

    // проверка кода верификации
    @PostMapping("/verify-code")
    public ResponseEntity<?> verifyCode(@RequestBody VerifyCodeDto dto, HttpSession session) {
        TeacherModel teacher = (TeacherModel) session.getAttribute("teacher");
        if (teacher == null) {
            return ResponseEntity.status(401).body("Не авторизован");
        }

        String sessionKey = session.getId();
        VerificationData verificationData = verificationCodes.get(sessionKey);

        if (verificationData == null) {
            return ResponseEntity.badRequest().body("Код не запрашивался или сессия устарела");
        }

        if (!verificationData.isValid()) {
            verificationCodes.remove(sessionKey);
            return ResponseEntity.badRequest().body("Время действия кода истекло");
        }

        if (!verificationData.method.equals(dto.getMethod())) {
            return ResponseEntity.badRequest().body("Неверный метод верификации");
        }

        if (!verificationData.code.equals(dto.getCode())) {
            return ResponseEntity.badRequest().body("Неверный код подтверждения");
        }

        //код верный - удаляем его
        verificationCodes.remove(sessionKey);

        // устанавливаем флаг успешной верификации в сессии
        session.setAttribute("verified", true);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Верификация успешна");
        response.put("teacher", Map.of(
                "id", teacher.getId(),
                "fio", teacher.getFio(),
                "email", teacher.getEmail(),
                "phone", teacher.getPhone()
        ));

        return ResponseEntity.ok(response);
    }

    // Выход
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        // удаляем код верификации если есть
        verificationCodes.remove(session.getId());
        session.invalidate();
        return ResponseEntity.ok("Выход выполнен");
    }

    // проверка авторизации
    @GetMapping("/check")
    public ResponseEntity<?> checkAuth(HttpSession session) {
        TeacherModel teacher = (TeacherModel) session.getAttribute("teacher");
        if (teacher == null) {
            return ResponseEntity.status(401).body("Не авторизован");
        }

        Boolean verified = (Boolean) session.getAttribute("verified");
        Map<String, Object> response = new HashMap<>();
        response.put("teacher", teacher);
        response.put("verified", Boolean.TRUE.equals(verified));

        return ResponseEntity.ok(response);
    }

    // для генерации кода
    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6-значный код
        return String.valueOf(code);
    }

    // для очистки устаревших кодов
    public void cleanupExpiredCodes() {
        LocalDateTime now = LocalDateTime.now();
        verificationCodes.entrySet().removeIf(entry ->
                entry.getValue().expiresAt.isBefore(now)
        );
    }
}