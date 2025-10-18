package org.work_program.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class CompetenceIndicatorDto {
    private Long id;
    private Long competenceId;
    private String code;
    private String desc;

    public CompetenceIndicatorDto(Long id, Long competenceId, String code, String desc) {
        this.id = id;
        this.competenceId = competenceId;
        this.code = code;
        this.desc = desc;
    }
}
