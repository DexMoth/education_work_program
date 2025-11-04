package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.CurriculumDisciplineDto;
import org.work_program.models.CurriculumDisciplineModel;
import org.work_program.repositories.CurriculumDisciplineRepository;
import org.work_program.services.CurriculumDisciplineService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/curriculumDiscipline")
public class CurriculumDisciplineController {
    private final CurriculumDisciplineRepository curriculumRepository;
    private final CurriculumDisciplineService curriculumDisciplineService;
    private final ModelMapper modelMapper;

    public CurriculumDisciplineController(CurriculumDisciplineRepository curriculumDisciplineRepository, CurriculumDisciplineService curriculumDisciplineService, ModelMapper modelMapper) {
        this.curriculumRepository = curriculumDisciplineRepository;
        this.curriculumDisciplineService = curriculumDisciplineService;
        this.modelMapper = modelMapper;
    }

    private CurriculumDisciplineDto toDto(CurriculumDisciplineModel ent) {
        return new CurriculumDisciplineDto(
                ent.getId(),
                ent.getStudyForm(),
                ent.getSemesterNumber(),
                ent.getTotalContactHours(),
                ent.getLectureHours(),
                ent.getPracticeHours(),
                ent.getLabHours(),
                ent.getTotalSelfStudyHours(),
                ent.getConsultationHours(),
                ent.getTheoryStudyHours(),
                ent.getCourseProjectHours(),
                ent.getRgrHours(),
                ent.getEssayHours(),
                ent.getPracticePreparationHours(),
                ent.getLabPreparationHours(),
                ent.getIntermediateAssessmentHours(),
                ent.getTotalHours(),
                ent.getCredits(),
                ent.getAssessmentForm(),
                ent.getCreatedAt(),
                ent.getDiscipline().getId(),
                ent.getDepartment().getId(),
                ent.getCurriculum().getId()
        );
    }

    private CurriculumDisciplineModel toEntity(CurriculumDisciplineDto dto) {
        var ent = modelMapper.map(dto, CurriculumDisciplineModel.class);
        return ent;
    }

    @PostMapping
    public CurriculumDisciplineDto create(@RequestBody @Valid CurriculumDisciplineDto dto) {
        return toDto(curriculumDisciplineService.create(toEntity(dto)));
    }

    @GetMapping
    public List<CurriculumDisciplineDto> getAll() {
        return curriculumDisciplineService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/byCurriculum/{curriculumId}")
    public List<CurriculumDisciplineDto> getByCurriculumId(@PathVariable(name = "curriculumId") Long curriculumId) {
        return curriculumDisciplineService.getByCurriculumId(curriculumId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CurriculumDisciplineDto get(@PathVariable(name = "id") Long id) {
        return toDto(curriculumDisciplineService.get(id));
    }

    @PutMapping("/{id}")
    public CurriculumDisciplineDto update(@PathVariable(name = "id") Long id, @RequestBody CurriculumDisciplineDto dto) {
        return toDto(curriculumDisciplineService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public CurriculumDisciplineDto delete(@PathVariable(name = "id") Long id) {
        return toDto(curriculumDisciplineService.delete(id));
    }
}
