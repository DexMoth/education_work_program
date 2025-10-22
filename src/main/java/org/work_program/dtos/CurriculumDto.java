package org.work_program.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CurriculumDto {
    private Long id;
    private Long studyDirectionId;
    private Long studyFormId;
    private String academicYear;
    private String name;

    public CurriculumDto(Long id, Long studyDirectionId, Long studyFormId, String academicYear, String name) {
        this.id = id;
        this.studyDirectionId = studyDirectionId;
        this.studyFormId = studyFormId;
        this.academicYear = academicYear;
        this.name = name;
    }
}
