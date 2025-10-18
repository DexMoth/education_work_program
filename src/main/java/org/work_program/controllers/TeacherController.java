package org.work_program.controllers;

import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.TeacherDto;
import org.work_program.models.TeacherModel;
import org.work_program.repositories.TeacherRepository;
import org.work_program.services.TeacherService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.API_URL + "/teacher")
public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final TeacherService teacherService;
    private final ModelMapper modelMapper;

    public TeacherController(TeacherRepository teacherRepository, TeacherService teacherService, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
    }

    private TeacherDto toDto(TeacherModel ent) {
        return new TeacherDto(
                ent.getId(),
                ent.getFio(),
                ent.getPhone(),
                ent.getEmail(),
                ent.getIsActive(),
                ent.getDepartment().getId(),
                ent.getPosition().getId()
        );
    }

    private TeacherModel toEntity(TeacherDto dto) {
        var ent = modelMapper.map(dto, TeacherModel.class);
        return ent;
    }

    @GetMapping("/me")
    public ResponseEntity<TeacherDto> getCurrentTeacher(HttpSession session) {
        TeacherModel sessionTeacher = (TeacherModel) session.getAttribute("teacher");
        if (sessionTeacher == null) {
            return ResponseEntity.status(401).build();
        }

        TeacherModel teacher = teacherService.get(sessionTeacher.getId());

        return ResponseEntity.ok(new TeacherDto(
                teacher.getId(),
                teacher.getFio(),
                teacher.getPhone(),
                teacher.getEmail(),
                teacher.getIsActive(),
                teacher.getDepartment().getId(),
                teacher.getPosition().getId()
        ));
    }

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody TeacherModel request,
                                     BindingResult bindingResult) {

        // Валидация входных данных
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            // Создание пользователя
            TeacherModel teacher = new TeacherModel();
            teacher.setFio(request.getFio());
            teacher.setPhone(request.getPhone());
            teacher.setEmail(request.getEmail());
            teacher.setIsActive(request.getIsActive());
            teacher.setDepartment(request.getDepartment());
            teacher.setPosition(request.getPosition());
            System.out.println(teacher);

            // Сохранение пользователя
            TeacherModel createdTeacher = teacherService.create(teacher);

            return ResponseEntity.ok(Collections.singletonMap("message", "Teacher registered successfully"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Registration failed: " + e.getMessage()));
        }
    }

    @GetMapping
    public List<TeacherDto> getAll() {
        return teacherService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public TeacherDto get(@PathVariable(name = "id") Long id) {
        return toDto(teacherService.get(id));
    }

    @PutMapping("/{id}")
    public TeacherDto update(@PathVariable(name = "id") Long id, @RequestBody TeacherDto dto) {
        return toDto(teacherService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public TeacherDto delete(@PathVariable(name = "id") Long id) {
        return toDto(teacherService.delete(id));
    }
}
