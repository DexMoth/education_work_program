package org.work_program.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class DepartmentModel extends BaseModel {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate createdAt;
    @Column(nullable = false)
    private FacultyModel faculty;
}
