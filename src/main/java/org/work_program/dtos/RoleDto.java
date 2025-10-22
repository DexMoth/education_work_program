package org.work_program.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private String name;

    public RoleDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
