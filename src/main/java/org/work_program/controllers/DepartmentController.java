package org.work_program.controllers;

import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.CompetenceDto;
import org.work_program.dtos.DepartmentDto;
import org.work_program.models.DepartmentModel;
import org.work_program.repositories.DepartmentRepository;
import org.work_program.services.DepartmentService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.API_URL + "/department")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    public DepartmentController(DepartmentRepository departmentRepository, DepartmentService departmentService, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    private DepartmentDto toDto(DepartmentModel ent) {
        return new DepartmentDto(
                ent.getId(),
                ent.getName(),
                ent.getFaculty().getId(),
                ent.getCreatedAt()
        );
    }

    private DepartmentModel toEntity(DepartmentDto dto) {
        var ent = modelMapper.map(dto, DepartmentModel.class);
        return ent;
    }

    @PostMapping
    public DepartmentDto create(@RequestBody @Valid DepartmentDto dto) {
        return toDto(departmentService.create(toEntity(dto)));
    }

    @GetMapping
    public List<DepartmentDto> getAll() {
        return departmentService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public DepartmentDto get(@PathVariable(name = "id") Long id) {
        return toDto(departmentService.get(id));
    }

    @PutMapping("/{id}")
    public DepartmentDto update(@PathVariable(name = "id") Long id, @RequestBody DepartmentDto dto) {
        return toDto(departmentService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public DepartmentDto delete(@PathVariable(name = "id") Long id) {
        return toDto(departmentService.delete(id));
    }
}
