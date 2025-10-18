package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.StudyDirectionDto;
import org.work_program.models.StudyDirectionModel;
import org.work_program.repositories.StudyDirectionRepository;
import org.work_program.services.StudyDirectionService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/studyDirection")
public class StudyDirectionController {
    private final StudyDirectionRepository studyDirectionRepository;
    private final StudyDirectionService studyDirectionService;
    private final ModelMapper modelMapper;

    public StudyDirectionController(StudyDirectionRepository studyDirectionRepository, StudyDirectionService studyDirectionService, ModelMapper modelMapper) {
        this.studyDirectionRepository = studyDirectionRepository;
        this.studyDirectionService = studyDirectionService;
        this.modelMapper = modelMapper;
    }

    private StudyDirectionDto toDto(StudyDirectionModel ent) {
        return new StudyDirectionDto(
                ent.getId(),
                ent.getName(),
                ent.getCode(),
                ent.getDepartment().getId(),
                ent.getCreatedAt()
        );
    }

    private StudyDirectionModel toEntity(StudyDirectionDto dto) {
        var ent = modelMapper.map(dto, StudyDirectionModel.class);
        return ent;
    }

    @PostMapping
    public StudyDirectionDto create(@RequestBody @Valid StudyDirectionDto dto) {
        return toDto(studyDirectionService.create(toEntity(dto)));
    }

    @GetMapping
    public List<StudyDirectionDto> getAll() {
        return studyDirectionService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public StudyDirectionDto get(@PathVariable(name = "id") Long id) {
        return toDto(studyDirectionService.get(id));
    }

    @PutMapping("/{id}")
    public StudyDirectionDto update(@PathVariable(name = "id") Long id, @RequestBody StudyDirectionDto dto) {
        return toDto(studyDirectionService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public StudyDirectionDto delete(@PathVariable(name = "id") Long id) {
        return toDto(studyDirectionService.delete(id));
    }
}
