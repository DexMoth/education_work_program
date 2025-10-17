package org.work_program.dtos;

import java.time.LocalDateTime;

public class CurriculumDisciplineDto {
    private Long id;
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

    private Long disciplineId;
    private Long departmentId;
    private Long curriculumId;
}
