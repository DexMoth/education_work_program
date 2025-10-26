package org.work_program.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class DisciplineDto {
    private Long id;
    private String name;
    private Long departmentId;
    private LocalDate createdAt;
    private Set<CompetenceDto> competenciesIds = new HashSet<>();

    public DisciplineDto(Long id, String name, Long departmentId, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.createdAt = createdAt;
    }

    public DisciplineDto(Long id, String name, Long departmentId, LocalDate createdAt,
                         Set<CompetenceDto> competenciesIds) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.createdAt = createdAt;
        this.competenciesIds = competenciesIds;
    }
}
