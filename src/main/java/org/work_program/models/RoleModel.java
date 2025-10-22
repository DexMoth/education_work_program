package org.work_program.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "roles")
public class RoleModel extends BaseModel{
    @Column(nullable = false)
    private String title;
}
