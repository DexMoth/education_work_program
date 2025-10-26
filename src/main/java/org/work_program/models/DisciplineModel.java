package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "disciplines")
public class DisciplineModel extends BaseModel{
    @NonNull
    @Column(nullable = false)
    private String name;
    @NonNull
    @Column(nullable = false)
    private LocalDate createdAt;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentModel department;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "discipline_competencies",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private Set<CompetenceModel> competencies = new HashSet<>();

    public void addCompetence (CompetenceModel c) {
        competencies.add(c);
    }
}
