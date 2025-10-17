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
@Table(name = "competence")
public class CompetenceModel extends BaseModel {
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String desc;
    @Column(nullable = false)
    private StudyDirectionModel studyDirection;
}
