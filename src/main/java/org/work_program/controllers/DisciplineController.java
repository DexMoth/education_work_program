package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.CompetenceDto;
import org.work_program.dtos.DisciplineDto;
import org.work_program.models.CompetenceModel;
import org.work_program.models.DisciplineModel;
import org.work_program.repositories.DisciplineRepository;
import org.work_program.services.CompetenceService;
import org.work_program.services.DisciplineService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.API_URL + "/discipline")
public class DisciplineController {
    private final DisciplineRepository disciplineRepository;
    private final DisciplineService disciplineService;
    private final CompetenceService competenceService;
    private final ModelMapper modelMapper;

    public DisciplineController(DisciplineRepository disciplineRepository, DisciplineService disciplineService, CompetenceService competenceService, ModelMapper modelMapper) {
        this.disciplineRepository = disciplineRepository;
        this.disciplineService = disciplineService;
        this.competenceService = competenceService;
        this.modelMapper = modelMapper;
    }

    private DisciplineDto toDto(DisciplineModel ent) {
        if (!ent.getCompetencies().isEmpty()) {
            return new DisciplineDto(
                    ent.getId(),
                    ent.getName(),
                    ent.getDepartment().getId(),
                    ent.getCreatedAt(),
                    ent.getCompetencies().stream()
                            .map(c -> new CompetenceDto(
                                    c.getId(),
                                    c.getCode(),
                                    c.getDescription()
                            ))
                            .collect(Collectors.toSet())
            );
        } else {
            return new DisciplineDto(
                    ent.getId(),
                    ent.getName(),
                    ent.getDepartment().getId(),
                    ent.getCreatedAt()
            );
        }
    }

    private DisciplineModel toEntity(DisciplineDto dto) {
        var ent = modelMapper.map(dto, DisciplineModel.class);
        if (dto.getCompetenciesIds() != null )
        {
            var competencies = dto.getCompetenciesIds();
            if( !competencies.isEmpty()) {
                for (var c : competencies){
                    ent.addCompetence(modelMapper.map(c, CompetenceModel.class));
                }
            }
        }
        return ent;
    }

    @PostMapping
    public DisciplineDto create(@RequestBody @Valid DisciplineDto dto) {
        return toDto(disciplineService.create(toEntity(dto)));
    }

    @GetMapping
    public List<DisciplineDto> getAll() {
        return disciplineService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public DisciplineDto get(@PathVariable(name = "id") Long id) {
        return toDto(disciplineService.get(id));
    }

    @PutMapping("/{id}")
    public DisciplineDto update(@PathVariable(name = "id") Long id, @RequestBody DisciplineDto dto) {
        return toDto(disciplineService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public DisciplineDto delete(@PathVariable(name = "id") Long id) {
        return toDto(disciplineService.delete(id));
    }
}
