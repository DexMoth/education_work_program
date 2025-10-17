package org.work_program.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "work_program")
public class WorkProgramModel extends BaseModel{
    private CurriculumDisciplineModel curriculumDiscipline;
    @Column(nullable = false)
    private TeacherModel teacher;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
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
