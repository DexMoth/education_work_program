package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.StatusModel;
import org.work_program.repositories.StatusRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class StatusService {
    private final StatusRepository repository;

    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<StatusModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public StatusModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(StatusModel.class, id));
    }

    @Transactional
    public StatusModel create(StatusModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public StatusModel update(Long id,  StatusModel entity) {
        StatusModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(StatusModel.class, id));
        el.setName(entity.getName());
        return repository.save(el);
    }

    @Transactional
    public StatusModel delete(Long id) {
        final StatusModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
