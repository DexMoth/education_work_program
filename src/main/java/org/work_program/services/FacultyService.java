package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.FacultyModel;
import org.work_program.repositories.FacultyRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class FacultyService {
    private final FacultyRepository repository;

    public FacultyService(FacultyRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<FacultyModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public FacultyModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(FacultyModel.class, id));
    }

    @Transactional
    public FacultyModel create(FacultyModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public FacultyModel update(Long id,  FacultyModel entity) {
        FacultyModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(FacultyModel.class, id));
        entity.setName(el.getName());
        entity.setCreatedAt(el.getCreatedAt());
        return repository.save(el);
    }

    @Transactional
    public FacultyModel delete(Long id) {
        final FacultyModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
