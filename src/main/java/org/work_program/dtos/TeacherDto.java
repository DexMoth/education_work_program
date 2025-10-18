package org.work_program.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.work_program.models.DepartmentModel;
import org.work_program.models.PositionModel;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private Long id;
    private String fio;
    private String phone;
    private String email;
    private Boolean isActive;
    private Long departmentId;
    private Long positionId;

    public TeacherDto(Long id, String fio, String phone, String email, Boolean isActive, Long departmentId, Long positionId) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;
        this.email = email;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.positionId = positionId;
    }
}
