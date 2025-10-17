package org.work_program.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.work_program.dtos.CurriculumDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_discipline")
public class CurriculumDisciplineModel extends BaseModel {
    private Integer semesterNumber;

    // Контактная работа с преподавателем
    private Integer totalContactHours;
    private Integer lectureHours;
    private Integer practiceHours;
    private Integer labHours;

    // Самостоятельная работа обучающихся
    private Integer totalSelfStudyHours;
    private Integer consultationHours;
    private Integer theoryStudyHours;
    private Integer courseProjectHours;
    private Integer rgrHours;
    private Integer essayHours;
    private Integer practicePreparationHours;
    private Integer labPreparationHours;
    private Integer eLearningHours;

    // Промежуточная аттестация
    private Integer intermediateAssessmentHours;

    // Итоговые показатели
    private Integer totalHours;
    private Integer credits;

    // Форма аттестации
    private String assessmentForm;
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private DisciplineModel discipline;
    @Column(nullable = false)
    private DepartmentModel department;
    @Column(nullable = false)
    private CurriculumDto curriculum;
}
