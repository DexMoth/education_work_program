package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.FacultyDto;
import org.work_program.models.FacultyModel;
import org.work_program.repositories.FacultyRepository;
import org.work_program.services.FacultyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/faculty")
public class FacultyController {
    private final FacultyRepository facultyRepository;
    private final FacultyService facultyService;
    private final ModelMapper modelMapper;

    public FacultyController(FacultyRepository facultyRepository, FacultyService facultyService, ModelMapper modelMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyService = facultyService;
        this.modelMapper = modelMapper;
    }

    private FacultyDto toDto(FacultyModel ent) {
        return new FacultyDto(
                ent.getId(),
                ent.getName(),
                ent.getCreatedAt()
        );
    }

    private FacultyModel toEntity(FacultyDto dto) {
        var ent = modelMapper.map(dto, FacultyModel.class);
        return ent;
    }

    @PostMapping
    public FacultyDto create(@RequestBody @Valid FacultyDto dto) {
        return toDto(facultyService.create(toEntity(dto)));
    }

    @GetMapping
    public List<FacultyDto> getAll() {
        return facultyService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public FacultyDto get(@PathVariable(name = "id") Long id) {
        return toDto(facultyService.get(id));
    }

    @PutMapping("/{id}")
    public FacultyDto update(@PathVariable(name = "id") Long id, @RequestBody FacultyDto dto) {
        return toDto(facultyService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public FacultyDto delete(@PathVariable(name = "id") Long id) {
        return toDto(facultyService.delete(id));
    }
}
