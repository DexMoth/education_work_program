package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.StatusDto;
import org.work_program.models.StatusModel;
import org.work_program.repositories.StatusRepository;
import org.work_program.services.StatusService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/status")
public class StatusController {
    private final StatusRepository statusRepository;
    private final StatusService statusService;
    private final ModelMapper modelMapper;

    public StatusController(StatusRepository statusRepository, StatusService statusService, ModelMapper modelMapper) {
        this.statusRepository = statusRepository;
        this.statusService = statusService;
        this.modelMapper = modelMapper;
    }

    private StatusDto toDto(StatusModel ent) {
        return new StatusDto(
                ent.getId(),
                ent.getName()
        );
    }

    private StatusModel toEntity(StatusDto dto) {
        var ent = modelMapper.map(dto, StatusModel.class);
        return ent;
    }

    @PostMapping
    public StatusDto create(@RequestBody @Valid StatusDto dto) {
        return toDto(statusService.create(toEntity(dto)));
    }

    @GetMapping
    public List<StatusDto> getAll() {
        return statusService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public StatusDto get(@PathVariable(name = "id") Long id) {
        return toDto(statusService.get(id));
    }

    @PutMapping("/{id}")
    public StatusDto update(@PathVariable(name = "id") Long id, @RequestBody StatusDto dto) {
        return toDto(statusService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public StatusDto delete(@PathVariable(name = "id") Long id) {
        return toDto(statusService.delete(id));
    }
}
