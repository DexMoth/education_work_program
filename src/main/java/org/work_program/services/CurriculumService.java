package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.CurriculumModel;
import org.work_program.repositories.CurriculumRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CurriculumService {
    private final CurriculumRepository repository;

    public CurriculumService(CurriculumRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<CurriculumModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public CurriculumModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CurriculumModel.class, id));
    }

    @Transactional
    public CurriculumModel create(CurriculumModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public CurriculumModel update(Long id,  CurriculumModel entity) {
        CurriculumModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CurriculumModel.class, id));

        el.setStudyDirection(entity.getStudyDirection());
        el.setStudyForm(entity.getStudyForm());
        el.setAcademicYear(entity.getAcademicYear());
        el.setName(entity.getName());
        return repository.save(el);
    }

    @Transactional
    public CurriculumModel delete(Long id) {
        final CurriculumModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
