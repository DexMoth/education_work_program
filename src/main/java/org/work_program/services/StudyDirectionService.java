package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.DepartmentModel;
import org.work_program.models.StudyDirectionModel;
import org.work_program.repositories.StudyDirectionRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class StudyDirectionService {
    private final StudyDirectionRepository repository;
    private final DepartmentService departmentService;

    public StudyDirectionService(StudyDirectionRepository repository, DepartmentService departmentService) {
        this.repository = repository;
        this.departmentService = departmentService;
    }

    @Transactional
    public List<StudyDirectionModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public StudyDirectionModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(StudyDirectionModel.class, id));
    }

    @Transactional
    public StudyDirectionModel create(StudyDirectionModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public StudyDirectionModel update(Long id, StudyDirectionModel entity) {
        StudyDirectionModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(StudyDirectionModel.class, id));
        final DepartmentModel dep = departmentService.get(el.getDepartment().getId());
        entity.setName(el.getName());
        entity.setCode(el.getCode());
        entity.setCreatedAt(el.getCreatedAt());
        entity.setDepartment(dep);
        return repository.save(el);
    }

    @Transactional
    public StudyDirectionModel delete(Long id) {
        final StudyDirectionModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
