package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "teachers")
public class TeacherModel extends BaseModel{
    @NonNull
    @Column(nullable = false)
    private String fio;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @NonNull
    @Column(nullable = false, name = "is_active")
    private Boolean isActive;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentModel department;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionModel position;
}
