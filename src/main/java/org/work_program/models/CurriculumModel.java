package org.work_program.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum")
public class CurriculumModel extends BaseModel {
    @Column(nullable = false)
    private StudyDirectionModel studyDirection;
    @Column(nullable = false)
    private StudyFormModel studyForm;
    @Column(nullable = false)
    private String academicYear;
    @Column(nullable = false)
    private String name;
}
