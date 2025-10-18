package org.work_program.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class DisciplineDto {
    private Long id;
    private String name;
    private Long departmentId;
    private LocalDate createdAt;

    public DisciplineDto(Long id, String name, Long departmentId, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.createdAt = createdAt;
    }
}
