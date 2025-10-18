package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.CompetenceIndicatorModel;
import org.work_program.repositories.CompetenceIndicatorRepository;
import org.work_program.repositories.CompetenceRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CompetenceIndicatorService {
    private final CompetenceIndicatorRepository repository;

    public CompetenceIndicatorService(CompetenceIndicatorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<CompetenceIndicatorModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public CompetenceIndicatorModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CompetenceIndicatorModel.class, id));
    }

    @Transactional
    public CompetenceIndicatorModel create(CompetenceIndicatorModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public CompetenceIndicatorModel update(Long id,  CompetenceIndicatorModel entity) {
        CompetenceIndicatorModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CompetenceIndicatorModel.class, id));
        entity.setCompetence(el.getCompetence());
        entity.setCode(el.getCode());
        entity.setDesc(el.getDesc());
        return repository.save(el);
    }

    @Transactional
    public CompetenceIndicatorModel delete(Long id) {
        final CompetenceIndicatorModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
