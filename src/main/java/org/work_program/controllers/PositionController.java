package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.PositionDto;
import org.work_program.models.PositionModel;
import org.work_program.repositories.PositionRepository;
import org.work_program.services.PositionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/position")
public class PositionController {
    private final PositionRepository positionRepository;
    private final PositionService positionService;
    private final ModelMapper modelMapper;

    public PositionController(PositionRepository positionRepository, PositionService positionService, ModelMapper modelMapper) {
        this.positionRepository = positionRepository;
        this.positionService = positionService;
        this.modelMapper = modelMapper;
    }

    private PositionDto toDto(PositionModel ent) {
        return new PositionDto(
                ent.getId(),
                ent.getName()
        );
    }

    private PositionModel toEntity(PositionDto dto) {
        var ent = modelMapper.map(dto, PositionModel.class);
        return ent;
    }

    @PostMapping
    public PositionDto create(@RequestBody @Valid PositionDto dto) {
        return toDto(positionService.create(toEntity(dto)));
    }

    @GetMapping
    public List<PositionDto> getAll() {
        return positionService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public PositionDto get(@PathVariable(name = "id") Long id) {
        return toDto(positionService.get(id));
    }

    @PutMapping("/{id}")
    public PositionDto update(@PathVariable(name = "id") Long id, @RequestBody PositionDto dto) {
        return toDto(positionService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public PositionDto delete(@PathVariable(name = "id") Long id) {
        return toDto(positionService.delete(id));
    }
}
