package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.TeacherModel;
import org.work_program.repositories.TeacherRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<TeacherModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public TeacherModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(TeacherModel.class, id));
    }

    @Transactional
    public TeacherModel create(TeacherModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public TeacherModel update(Long id,  TeacherModel entity) {
        TeacherModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(TeacherModel.class, id));
        entity.setFio(el.getFio());
        entity.setPhone(el.getPhone());
        entity.setEmail(el.getEmail());
        entity.setDepartment(el.getDepartment());
        entity.setIsActive(el.getIsActive());
        entity.setPosition(el.getPosition());
        return repository.save(el);
    }

    @Transactional
    public TeacherModel delete(Long id) {
        final TeacherModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
