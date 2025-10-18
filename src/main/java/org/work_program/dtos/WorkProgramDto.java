package org.work_program.dtos;

import org.work_program.enums.Status;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class WorkProgramDto {
    private Long id;
    private Long curriculumDisciplineId;
    private Long teacherId;
    private Status status;
    private LocalDateTime createdAt;

    // основные поля
    private String languages;
    private String goals;
    private String tasks;
    private String competencies;
    private String learningOutcomes;
    private String requirements;
    private String contentByWeeks;
    private String assessmentTools;
    private String gradingSystem;
    private String educationalTechnology;
    private String logistics;
    private String references;
}
