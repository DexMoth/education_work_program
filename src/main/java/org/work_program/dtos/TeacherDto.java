package org.work_program.dtos;

import lombok.*;
import org.work_program.models.DepartmentModel;
import org.work_program.models.PositionModel;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class TeacherDto {
    @NonNull
    private Long id;
    @NonNull
    private String fio;
    private String phone;
    private String login;
    private String password;
    private String email;
    @NonNull
    private Boolean isActive;
    @NonNull
    private Long departmentId;
    @NonNull
    private Long positionId;
    private Long roleId;

    public TeacherDto(Long id, String fio, String phone, String email, String login, String password, Boolean isActive, Long departmentId, Long positionId, Long roleId) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.roleId = roleId;
    }
}
