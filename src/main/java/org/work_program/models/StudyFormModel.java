package org.work_program.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "study_forms")
public class StudyFormModel extends BaseModel{
    @Column(nullable = false)
    private String name;
}
