package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.dtos.WorkProgramFullDto;
import org.work_program.error.NotFoundException;
import org.work_program.models.WorkProgramModel;
import org.work_program.repositories.CurriculumDisciplineRepository;
import org.work_program.repositories.FacultyRepository;
import org.work_program.repositories.TeacherRepository;
import org.work_program.repositories.WorkProgramRepository;

import java.util.Arrays;
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

    public List<WorkProgramModel> getMyWorkPrograms(Long teacherId) {
        return repository.findByTeacherId(teacherId);
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
        el.setCurriculumDiscipline(entity.getCurriculumDiscipline());
        el.setTeacher(entity.getTeacher());
        el.setStatus(entity.getStatus());
        el.setCreatedAt(entity.getCreatedAt());
        el.setLanguages(entity.getLanguages());
        el.setGoals(entity.getGoals());
        el.setTasks(entity.getTasks());
        el.setCompetencies(entity.getCompetencies());
        el.setLearningOutcomes(entity.getLearningOutcomes());
        el.setRequirements(entity.getRequirements());
        el.setContentByWeeks(entity.getContentByWeeks());
        el.setAssessmentTools(entity.getAssessmentTools());
        el.setGradingSystem(entity.getGradingSystem());
        el.setEducationalTechnology(entity.getEducationalTechnology());
        el.setLogistics(entity.getLogistics());
        el.setReferences_t(entity.getReferences_t());
        return repository.save(el);
    }

    @Transactional
    public WorkProgramModel delete(Long id) {
        final WorkProgramModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }

    public List<WorkProgramModel> getFilteredWorkPrograms(Long departmentId, Long curriculumId) {
        if (departmentId != null && curriculumId == null) {
            return repository.findByDepartment(departmentId);
        }
        else if (curriculumId != null && departmentId == null) {
            return repository.findByCurriculum(curriculumId);
        }
        else if (departmentId != null && curriculumId != null) {
            return repository.findByDepartmentAndCurriculum(departmentId, curriculumId);
        }
        else {
            return repository.findAll();
        }
    }
}
