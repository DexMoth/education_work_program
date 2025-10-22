package org.work_program.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class StudyFormDto {
    private Long id;
    private String name;

    public StudyFormDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
