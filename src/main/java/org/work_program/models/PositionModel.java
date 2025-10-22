package org.work_program.models;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "positions")
public class PositionModel extends BaseModel{
    @NonNull
    @Column(nullable = false)
    private String name;
}
