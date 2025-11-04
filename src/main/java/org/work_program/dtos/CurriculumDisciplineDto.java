package org.work_program.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class CurriculumDisciplineDto {
    @NonNull
    private Long id;
    @NonNull
    private Integer semesterNumber;
    @NonNull
    private String studyForm;

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
    private Long disciplineId;
    @NonNull
    private Long departmentId;
    private Long curriculumId;

    public CurriculumDisciplineDto(Long id, String studyForm, Integer semesterNumber, Integer totalContactHours, Integer lectureHours,
                                   Integer practiceHours, Integer labHours, Integer totalSelfStudyHours, Integer consultationHours,
                                   Integer theoryStudyHours, Integer courseProjectHours, Integer rgrHours, Integer essayHours,
                                   Integer practicePreparationHours, Integer labPreparationHours, Integer intermediateAssessmentHours,
                                   Integer totalHours, Integer credits, String assessmentForm, LocalDateTime createdAt,
                                   Long disciplineId, Long departmentId, Long curriculumId) {
        this.id = id;
        this.studyForm = studyForm;
        this.semesterNumber = semesterNumber;
        this.totalContactHours = totalContactHours;
        this.lectureHours = lectureHours;
        this.practiceHours = practiceHours;
        this.labHours = labHours;
        this.totalSelfStudyHours = totalSelfStudyHours;
        this.consultationHours = consultationHours;
        this.theoryStudyHours = theoryStudyHours;
        this.courseProjectHours = courseProjectHours;
        this.rgrHours = rgrHours;
        this.essayHours = essayHours;
        this.practicePreparationHours = practicePreparationHours;
        this.labPreparationHours = labPreparationHours;
        this.intermediateAssessmentHours = intermediateAssessmentHours;
        this.totalHours = totalHours;
        this.credits = credits;
        this.assessmentForm = assessmentForm;
        this.createdAt = createdAt;
        this.disciplineId = disciplineId;
        this.departmentId = departmentId;
        this.curriculumId = curriculumId;
    }
}
