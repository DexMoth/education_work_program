package org.work_program.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class StatusDto {
    private Long id;
    private String name;

    public StatusDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
