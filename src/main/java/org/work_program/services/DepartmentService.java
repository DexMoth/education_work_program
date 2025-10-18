package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.DepartmentModel;
import org.work_program.repositories.DepartmentRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<DepartmentModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public DepartmentModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(DepartmentModel.class, id));
    }

    @Transactional
    public DepartmentModel create(DepartmentModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public DepartmentModel update(Long id,  DepartmentModel entity) {
        DepartmentModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(DepartmentModel.class, id));
        entity.setName(el.getName());
        entity.setCreatedAt(el.getCreatedAt());
        entity.setFaculty(el.getFaculty());
        return repository.save(el);
    }

    @Transactional
    public DepartmentModel delete(Long id) {
        final DepartmentModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
