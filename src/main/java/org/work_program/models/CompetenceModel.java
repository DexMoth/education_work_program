package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "competencies")
public class CompetenceModel extends BaseModel {
    @NonNull
    @Column(nullable = false)
    private String code;
    @NonNull
    @Column(nullable = false)
    private String description;
}
