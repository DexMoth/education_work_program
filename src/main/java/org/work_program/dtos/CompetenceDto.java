package org.work_program.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class CompetenceDto {
    private Long id;
    private String code;
    private String desc;
    private Long studyDirectionId;
}
