package org.work_program.models;

import lombok.*;
import org.work_program.dtos.CurriculumDto;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_disciplines")
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

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipline_id", nullable = false)
    private DisciplineModel discipline;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentModel department;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id", nullable = false)
    private CurriculumModel curriculum;
}
