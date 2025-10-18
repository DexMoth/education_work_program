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
public class StudyDirectionDto {
    private Long id;
    private String name;
    private String code;
    private Long departmentId;
    private LocalDate createdAt;

    public StudyDirectionDto(Long id, String name, String code, Long departmentId, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.departmentId = departmentId;
        this.createdAt = createdAt;
    }
}
