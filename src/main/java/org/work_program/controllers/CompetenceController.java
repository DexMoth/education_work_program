package org.work_program.controllers;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.CompetenceDto;
import org.work_program.models.CompetenceModel;
import org.work_program.repositories.CompetenceRepository;
import org.work_program.services.CompetenceService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/competence")
public class CompetenceController {
    private final CompetenceService competenceService;
    private final ModelMapper modelMapper;

    public CompetenceController(CompetenceService competenceService, ModelMapper modelMapper) {
        this.competenceService = competenceService;
        this.modelMapper = modelMapper;
    }
    @Transactional
    private CompetenceDto toDto(CompetenceModel ent) {
        return new CompetenceDto(
                ent.getId(),
                ent.getCode(),
                ent.getDescription()
        );
    }

    private CompetenceModel toEntity(CompetenceDto dto) {
        var ent = modelMapper.map(dto, CompetenceModel.class);
        return ent;
    }

    @PostMapping
    public CompetenceDto create(@RequestBody @Valid CompetenceDto dto) {
        return toDto(competenceService.create(toEntity(dto)));
    }

    @GetMapping
    public List<CompetenceDto> getAll() {
        return competenceService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public CompetenceDto get(@PathVariable(name = "id") Long id) {
        return toDto(competenceService.get(id));
    }

    @PutMapping("/{id}")
    public CompetenceDto update(@PathVariable(name = "id") Long id, @RequestBody CompetenceDto dto) {
        return toDto(competenceService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public CompetenceDto delete(@PathVariable(name = "id") Long id) {
        return toDto(competenceService.delete(id));
    }

}
