package org.work_program.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.work_program.configurations.Constants;
import org.work_program.dtos.RoleDto;
import org.work_program.models.RoleModel;
import org.work_program.repositories.RoleRepository;
import org.work_program.services.RoleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/role")
public class RoleController {
    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    public RoleController(RoleRepository roleRepository, RoleService roleService, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    private RoleDto toDto(RoleModel ent) {
        return new RoleDto(
                ent.getId(),
                ent.getTitle()
        );
    }

    private RoleModel toEntity(RoleDto dto) {
        var ent = modelMapper.map(dto, RoleModel.class);
        return ent;
    }

    @PostMapping
    public RoleDto create(@RequestBody @Valid RoleDto dto) {
        return toDto(roleService.create(toEntity(dto)));
    }

    @GetMapping
    public List<RoleDto> getAll() {
        return roleService.getAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public RoleDto get(@PathVariable(name = "id") Long id) {
        return toDto(roleService.get(id));
    }

    @PutMapping("/{id}")
    public RoleDto update(@PathVariable(name = "id") Long id, @RequestBody RoleDto dto) {
        return toDto(roleService.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public RoleDto delete(@PathVariable(name = "id") Long id) {
        return toDto(roleService.delete(id));
    }
}
