package org.work_program.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.WorkProgramDto;
import org.work_program.models.TeacherModel;
import org.work_program.models.WorkProgramModel;
import org.work_program.repositories.WorkProgramRepository;
import org.work_program.services.WorkProgramService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/workProgram")
public class WorkProgramController {
    private final WorkProgramRepository workProgramRepository;
    private final WorkProgramService workProgramService;
    private final ModelMapper modelMapper;

    public WorkProgramController(WorkProgramRepository workProgramRepository, WorkProgramService workProgramService, ModelMapper modelMapper) {
        this.workProgramRepository = workProgramRepository;
        this.workProgramService = workProgramService;
        this.modelMapper = modelMapper;
    }

    private WorkProgramDto toDto(WorkProgramModel ent) {
        var dto = modelMapper.map(ent, WorkProgramDto.class);
        return dto;
    }

    private WorkProgramModel toEntity(WorkProgramDto dto) {
        var ent = modelMapper.map(dto, WorkProgramModel.class);
        return ent;
    }

    @PostMapping
    public WorkProgramDto create(@RequestBody @Valid WorkProgramDto dto) {
        return toDto(workProgramService.create(toEntity(dto)));
    }

    @GetMapping
    public List<WorkProgramDto> getAll(
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Long studyDirectionId) {
        if (departmentId != null || studyDirectionId != null) {
            return workProgramService.getFilteredWorkPrograms(departmentId, studyDirectionId)
                    .stream()
                    .map(this::toDto)
                    .toList();
        } else {
            return workProgramService.getAll().stream().map(this::toDto).toList();
        }
    }

    @GetMapping("/my")
    public ResponseEntity<List<WorkProgramDto>> getMy(HttpSession session) {
        TeacherModel currentTeacher = (TeacherModel) session.getAttribute("teacher");
        if (currentTeacher == null) {
            return ResponseEntity.status(401).build(); // Не авторизован
        }

        List<WorkProgramModel> myPrograms = workProgramService.getMyWorkPrograms(currentTeacher.getId());
        List<WorkProgramDto> dtos = myPrograms.stream()
                .map(this::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public WorkProgramDto get(@PathVariable(name = "id") Long id) {
        return toDto(workProgramService.get(id));
    }

    @PutMapping("/{id}")
    public WorkProgramDto update(@PathVariable(name = "id") Long id, @RequestBody WorkProgramDto dto) {
        return toDto(workProgramService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public WorkProgramDto delete(@PathVariable(name = "id") Long id) {
        return toDto(workProgramService.delete(id));
    }
}
