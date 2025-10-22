package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "study_directions")
public class StudyDirectionModel extends BaseModel{
    @NonNull
    @Column(nullable = false)
    private String name;
    @NonNull
    @Column(nullable = false)
    private String code;
    @NonNull
    @Column(nullable = false)
    private LocalDate createdAt  = LocalDate.now();
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentModel department;
}
