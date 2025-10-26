package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.CurriculumDto;
import org.work_program.models.CurriculumModel;
import org.work_program.repositories.CurriculumRepository;
import org.work_program.services.CurriculumService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/curriculum")
public class CurriculumController {
    private final CurriculumRepository curriculumRepository;
    private final CurriculumService curriculumService;
    private final ModelMapper modelMapper;

    public CurriculumController(CurriculumRepository curriculumRepository, CurriculumService curriculumService, ModelMapper modelMapper) {
        this.curriculumRepository = curriculumRepository;
        this.curriculumService = curriculumService;
        this.modelMapper = modelMapper;
    }

    private CurriculumDto toDto(CurriculumModel ent) {
        return new CurriculumDto(
                ent.getId(),
                ent.getStudyDirection().getId(),
                ent.getStudyForm().getId(),
                ent.getAcademicYear(),
                ent.getName()
        );
    }

    private CurriculumModel toEntity(CurriculumDto dto) {
        var ent = modelMapper.map(dto, CurriculumModel.class);
        return ent;
    }

    @PostMapping
    public CurriculumDto create(@RequestBody @Valid CurriculumDto dto) {
        return toDto(curriculumService.create(toEntity(dto)));
    }

    @GetMapping
    public List<CurriculumDto> getAll() {
        return curriculumService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public CurriculumDto get(@PathVariable(name = "id") Long id) {
        return toDto(curriculumService.get(id));
    }

    @GetMapping("/{id}/discipline")
    public CurriculumDto getWithDiscipline(@PathVariable(name = "id") Long id) {
        return toDto(curriculumService.get(id));
    }

    @PutMapping("/{id}")
    public CurriculumDto update(@PathVariable(name = "id") Long id, @RequestBody CurriculumDto dto) {
        return toDto(curriculumService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public CurriculumDto delete(@PathVariable(name = "id") Long id) {
        return toDto(curriculumService.delete(id));
    }
}
