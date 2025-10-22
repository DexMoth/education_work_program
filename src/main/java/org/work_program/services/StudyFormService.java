package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.StudyFormModel;
import org.work_program.repositories.StudyFormRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class StudyFormService {
    private final StudyFormRepository repository;

    public StudyFormService(StudyFormRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<StudyFormModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public StudyFormModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(StudyFormModel.class, id));
    }

    @Transactional
    public StudyFormModel create(StudyFormModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public StudyFormModel update(Long id,  StudyFormModel entity) {
        StudyFormModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(StudyFormModel.class, id));
        el.setName(entity.getName());
        return repository.save(el);
    }

    @Transactional
    public StudyFormModel delete(Long id) {
        final StudyFormModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
