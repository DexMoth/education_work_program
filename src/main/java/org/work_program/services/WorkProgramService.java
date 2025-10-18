package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.WorkProgramModel;
import org.work_program.repositories.WorkProgramRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class WorkProgramService {
    private final WorkProgramRepository repository;

    public WorkProgramService(WorkProgramRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<WorkProgramModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public WorkProgramModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(WorkProgramModel.class, id));
    }

    @Transactional
    public WorkProgramModel create(WorkProgramModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public WorkProgramModel update(Long id,  WorkProgramModel entity) {
        WorkProgramModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(WorkProgramModel.class, id));
        entity.setCurriculumDiscipline(el.getCurriculumDiscipline());
        entity.setTeacher(el.getTeacher());
        entity.setStatus(el.getStatus());
        entity.setCreatedAt(el.getCreatedAt());
        entity.setLanguages(el.getLanguages());
        entity.setGoals(el.getGoals());
        entity.setTasks(el.getTasks());
        entity.setCompetencies(el.getCompetencies());
        entity.setLearningOutcomes(el.getLearningOutcomes());
        entity.setRequirements(el.getRequirements());
        entity.setContentByWeeks(el.getContentByWeeks());
        entity.setAssessmentTools(el.getAssessmentTools());
        entity.setGradingSystem(el.getGradingSystem());
        entity.setEducationalTechnology(el.getEducationalTechnology());
        entity.setLogistics(el.getLogistics());
        entity.setReferences(el.getReferences());
        return repository.save(el);
    }

    @Transactional
    public WorkProgramModel delete(Long id) {
        final WorkProgramModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
