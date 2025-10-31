package org.work_program.models;

import lombok.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "competence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CompetenceIndicatorModel> indicators = new ArrayList<>();
}
