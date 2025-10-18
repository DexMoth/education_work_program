package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.DisciplineModel;
import org.work_program.repositories.DisciplineRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class DisciplineService {
    private final DisciplineRepository repository;

    public DisciplineService(DisciplineRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<DisciplineModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public DisciplineModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(DisciplineModel.class, id));
    }

    @Transactional
    public DisciplineModel create(DisciplineModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public DisciplineModel update(Long id,  DisciplineModel entity) {
        DisciplineModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(DisciplineModel.class, id));
        entity.setName(el.getName());
        entity.setCreatedAt(el.getCreatedAt());
        entity.setDepartment(el.getDepartment());
        return repository.save(el);
    }

    @Transactional
    public DisciplineModel delete(Long id) {
        final DisciplineModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
