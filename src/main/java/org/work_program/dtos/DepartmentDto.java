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
public class DepartmentDto {
    private Long id;
    private String name;
    private Long facultyId;
    private LocalDate createdAt;

    public DepartmentDto(Long id, String name, Long facultyId, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.facultyId = facultyId;
        this.createdAt = createdAt;
    }
}
