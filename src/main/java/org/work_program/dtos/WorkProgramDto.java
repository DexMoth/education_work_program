package org.work_program.dtos;

import java.time.LocalDateTime;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class WorkProgramDto {
    @NonNull
    private Long id;
    @NonNull
    private Long teacherId;
    @NonNull
    private Long statusId;
    private Long curriculumId;
    @NonNull
    private LocalDateTime createdAt = LocalDateTime.now();

    // основные поля
    private String languages;
    private String goals;
    private String tasks;
    private String competencies;
    private String learningOutcomes;
    private String requirements;
    private String thematicPlan;
    private String theoreticalCourse;
    private String practicalWork;
    private String laboratoryWorkshop;
    private String courseProject;
    private String independentWork;
    private String assessmentTools;
    private String gradingSystem;
    private String educationalTechnology;
    private String logistics;
    private String references_t;
}
