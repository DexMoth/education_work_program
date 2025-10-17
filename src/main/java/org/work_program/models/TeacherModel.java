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
@Table(name = "teacher")
public class TeacherModel extends BaseModel{
    @Column(nullable = false)
    private String fio;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean isActive;
    @Column(nullable = false)
    private DepartmentModel department;
    @Column(nullable = false)
    private PositionModel position;
}
