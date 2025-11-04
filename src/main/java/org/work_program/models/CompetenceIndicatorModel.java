package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "competence_indicators")
public class CompetenceIndicatorModel extends BaseModel{
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competence_id", nullable = false)
    private CompetenceModel competence;
    @NonNull
    @Column(nullable = false)
    private String code;
    @NonNull
    @Column(nullable = false)
    private String description;
}
