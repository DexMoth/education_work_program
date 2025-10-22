package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class DepartmentModel extends BaseModel {
    @NonNull
    @Column(nullable = false)
    private String name;
    @NonNull
    @Column(nullable = false)
    private LocalDate createdAt = LocalDate.now();
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    private FacultyModel faculty;
}
