package org.work_program.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class CompetenceDto {
    @NonNull
    private Long id;
    @NonNull
    private String code;
    @NonNull
    private String description;

    public CompetenceDto(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }
}
