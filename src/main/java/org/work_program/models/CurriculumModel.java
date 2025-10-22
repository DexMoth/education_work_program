package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum")
public class CurriculumModel extends BaseModel {
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_direction_id", nullable = false)
    private StudyDirectionModel studyDirection;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_form_id", nullable = false)
    private StudyFormModel studyForm;
    @NonNull
    @Column(nullable = false)
    private String academicYear;
    @NonNull
    @Column(nullable = false)
    private String name;
}
