package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.RoleModel;
import org.work_program.repositories.RoleRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<RoleModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public RoleModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(RoleModel.class, id));
    }

    @Transactional
    public RoleModel create(RoleModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public RoleModel update(Long id,  RoleModel entity) {
        RoleModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(RoleModel.class, id));
        el.setTitle(entity.getTitle());
        return repository.save(el);
    }

    @Transactional
    public RoleModel delete(Long id) {
        final RoleModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
