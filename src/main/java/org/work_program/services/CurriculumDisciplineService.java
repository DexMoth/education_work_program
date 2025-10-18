package org.work_program.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work_program.error.NotFoundException;
import org.work_program.models.CurriculumDisciplineModel;
import org.work_program.repositories.CurriculumDisciplineRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CurriculumDisciplineService {
    private final CurriculumDisciplineRepository repository;

    public CurriculumDisciplineService(CurriculumDisciplineRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<CurriculumDisciplineModel> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
    @Transactional
    public CurriculumDisciplineModel get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CurriculumDisciplineModel.class, id));
    }

    @Transactional
    public CurriculumDisciplineModel create(CurriculumDisciplineModel entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        return repository.save(entity);
    }
    @Transactional
    public CurriculumDisciplineModel update(Long id,  CurriculumDisciplineModel entity) {
        CurriculumDisciplineModel el = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(CurriculumDisciplineModel.class, id));
        entity.setCurriculum(el.getCurriculum());
        entity.setDiscipline(el.getDiscipline());
        entity.setCredits(el.getCredits());
        entity.setDepartment(el.getDepartment());
        entity.setAssessmentForm(el.getAssessmentForm());
        entity.setConsultationHours(el.getConsultationHours());
        entity.setELearningHours(el.getELearningHours());
        entity.setCourseProjectHours(el.getCourseProjectHours());
        entity.setEssayHours(el.getEssayHours());
        entity.setELearningHours(el.getELearningHours());
        entity.setIntermediateAssessmentHours(el.getIntermediateAssessmentHours());
        entity.setAssessmentForm(el.getAssessmentForm());
        entity.setLabHours(el.getLabHours());
        entity.setLabPreparationHours(el.getLabPreparationHours());
        entity.setLectureHours(el.getLectureHours());
        entity.setPracticeHours(el.getPracticeHours());
        entity.setPracticePreparationHours(el.getPracticePreparationHours());
        entity.setRgrHours(el.getRgrHours());
        entity.setSemesterNumber(el.getSemesterNumber());
        entity.setTheoryStudyHours(el.getTheoryStudyHours());
        entity.setTotalContactHours(el.getTotalContactHours());
        entity.setTotalHours(el.getTotalHours());
        entity.setTotalSelfStudyHours(el.getTotalSelfStudyHours());
        entity.setCreatedAt(el.getCreatedAt());
        return repository.save(el);
    }

    @Transactional
    public CurriculumDisciplineModel delete(Long id) {
        final CurriculumDisciplineModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }
}
