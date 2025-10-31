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
        el.setCurriculum(entity.getCurriculum());
        el.setDiscipline(entity.getDiscipline());
        el.setCredits(entity.getCredits());
        el.setDepartment(entity.getDepartment());
        el.setAssessmentForm(entity.getAssessmentForm());
        el.setConsultationHours(entity.getConsultationHours());
        el.setELearningHours(entity.getELearningHours());
        el.setCourseProjectHours(entity.getCourseProjectHours());
        el.setEssayHours(entity.getEssayHours());
        el.setELearningHours(entity.getELearningHours());
        el.setIntermediateAssessmentHours(entity.getIntermediateAssessmentHours());
        el.setAssessmentForm(entity.getAssessmentForm());
        el.setLabHours(entity.getLabHours());
        el.setLabPreparationHours(entity.getLabPreparationHours());
        el.setLectureHours(entity.getLectureHours());
        el.setPracticeHours(entity.getPracticeHours());
        el.setPracticePreparationHours(entity.getPracticePreparationHours());
        el.setRgrHours(entity.getRgrHours());
        el.setSemesterNumber(entity.getSemesterNumber());
        el.setTheoryStudyHours(entity.getTheoryStudyHours());
        el.setTotalContactHours(entity.getTotalContactHours());
        el.setTotalHours(entity.getTotalHours());
        el.setTotalSelfStudyHours(entity.getTotalSelfStudyHours());
        el.setCreatedAt(entity.getCreatedAt());
        return repository.save(el);
    }

    @Transactional
    public CurriculumDisciplineModel delete(Long id) {
        final CurriculumDisciplineModel existsEntity = get(id);
        repository.delete(existsEntity);
        return existsEntity;
    }

    @Transactional
    public List<CurriculumDisciplineModel> getByCurriculumId(Long curriculumId) {
        return repository.findByCurriculumId(curriculumId);
    }
}
