package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.CompetenceModel;
import org.work_program.repositories.CompetenceRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CompetenceService {
    private final CompetenceRepository repository;

    public CompetenceService(CompetenceRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<CompetenceModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public CompetenceModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CompetenceModel.class, id));
    }

    @Transactional
    public CompetenceModel create(CompetenceModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public CompetenceModel update(Long id, CompetenceModel entity) {
        CompetenceModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CompetenceModel.class, id));
        el.setCode(entity.getCode());
        el.setDesc(entity.getDesc());
        return repository.save(el);
    }

    @Transactional
    public CompetenceModel delete(Long id) {
        final CompetenceModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
