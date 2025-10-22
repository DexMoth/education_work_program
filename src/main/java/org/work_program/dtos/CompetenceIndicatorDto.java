package org.work_program.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class CompetenceIndicatorDto {
    @NonNull
    private Long id;
    @NonNull
    private Long competenceId;
    @NonNull
    private String code;
    @NonNull
    private String desc;

    public CompetenceIndicatorDto(Long id, Long competenceId, String code, String desc) {
        this.id = id;
        this.competenceId = competenceId;
        this.code = code;
        this.desc = desc;
    }
}
