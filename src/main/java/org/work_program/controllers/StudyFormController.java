package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.StudyFormDto;
import org.work_program.models.StudyFormModel;
import org.work_program.repositories.StudyFormRepository;
import org.work_program.services.StudyFormService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/study_form")
public class StudyFormController {
    private final StudyFormRepository studyFormRepository;
    private final StudyFormService studyFormService;
    private final ModelMapper modelMapper;

    public StudyFormController(StudyFormRepository studyFormRepository, StudyFormService studyFormService, ModelMapper modelMapper) {
        this.studyFormRepository = studyFormRepository;
        this.studyFormService = studyFormService;
        this.modelMapper = modelMapper;
    }

    private StudyFormDto toDto(StudyFormModel ent) {
        return new StudyFormDto(
                ent.getId(),
                ent.getName()
        );
    }

    private StudyFormModel toEntity(StudyFormDto dto) {
        var ent = modelMapper.map(dto, StudyFormModel.class);
        return ent;
    }

    @PostMapping
    public StudyFormDto create(@RequestBody @Valid StudyFormDto dto) {
        return toDto(studyFormService.create(toEntity(dto)));
    }

    @GetMapping
    public List<StudyFormDto> getAll() {
        return studyFormService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public StudyFormDto get(@PathVariable(name = "id") Long id) {
        return toDto(studyFormService.get(id));
    }

    @PutMapping("/{id}")
    public StudyFormDto update(@PathVariable(name = "id") Long id, @RequestBody StudyFormDto dto) {
        return toDto(studyFormService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public StudyFormDto delete(@PathVariable(name = "id") Long id) {
        return toDto(studyFormService.delete(id));
    }
}
