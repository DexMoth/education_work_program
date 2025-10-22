package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.PositionModel;
import org.work_program.repositories.PositionRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PositionService {
    private final PositionRepository repository;

    public PositionService(PositionRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<PositionModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public PositionModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(PositionModel.class, id));
    }

    @Transactional
    public PositionModel create(PositionModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public PositionModel update(Long id,  PositionModel entity) {
        PositionModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(PositionModel.class, id));
        el.setName(entity.getName());
        return repository.save(el);
    }

    @Transactional
    public PositionModel delete(Long id) {
        final PositionModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
