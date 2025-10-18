package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.CompetenceIndicatorDto;
import org.work_program.models.CompetenceIndicatorModel;
import org.work_program.repositories.CompetenceIndicatorRepository;
import org.work_program.services.CompetenceIndicatorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/competenceIndicator")
public class CompetenceIndicatorController {
    private final CompetenceIndicatorRepository competenceIndicatorRepository;
    private final CompetenceIndicatorService competenceIndicatorService;
    private final ModelMapper modelMapper;

    public CompetenceIndicatorController(CompetenceIndicatorRepository competenceIndicatorRepository, CompetenceIndicatorService competenceIndicatorService, ModelMapper modelMapper) {
        this.competenceIndicatorRepository = competenceIndicatorRepository;
        this.competenceIndicatorService = competenceIndicatorService;
        this.modelMapper = modelMapper;
    }

    private CompetenceIndicatorDto toDto(CompetenceIndicatorModel ent) {
        return new CompetenceIndicatorDto(
                ent.getId(),
                ent.getCompetence().getId(),
                ent.getCode(),
                ent.getDesc()
        );
    }

    private CompetenceIndicatorModel toEntity(CompetenceIndicatorDto dto) {
        var ent = modelMapper.map(dto, CompetenceIndicatorModel.class);
        return ent;
    }

    @PostMapping
    public CompetenceIndicatorDto create(@RequestBody @Valid CompetenceIndicatorDto dto) {
        return toDto(competenceIndicatorService.create(toEntity(dto)));
    }

    @GetMapping
    public List<CompetenceIndicatorDto> getAll() {
        return competenceIndicatorService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public CompetenceIndicatorDto get(@PathVariable(name = "id") Long id) {
        return toDto(competenceIndicatorService.get(id));
    }

    @PutMapping("/{id}")
    public CompetenceIndicatorDto update(@PathVariable(name = "id") Long id, @RequestBody CompetenceIndicatorDto dto) {
        return toDto(competenceIndicatorService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public CompetenceIndicatorDto delete(@PathVariable(name = "id") Long id) {
        return toDto(competenceIndicatorService.delete(id));
    }
}
