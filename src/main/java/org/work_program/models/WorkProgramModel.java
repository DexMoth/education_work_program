package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "work_programs")
public class WorkProgramModel extends BaseModel{
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherModel teacher;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private StatusModel status;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id", nullable = false)
    private CurriculumModel curriculum;
    @NonNull
    @Column(nullable = false)
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
