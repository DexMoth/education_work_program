package org.work_program.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.work_program.dtos.*;

import java.util.List;

// для генерации pdf документа
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkProgramFullDto {
    private WorkProgramDto workProgram;
    private CurriculumDisciplineDto curriculumDiscipline;
    private CurriculumDto curriculum;
    private DisciplineDto discipline;
    private TeacherDto teacher;
    private PositionDto teacherPosition;
    private DepartmentDto teacherDepartment;
    private DepartmentDto disciplineDepartment;
    private FacultyDto faculty;
    private StudyFormDto studyForm;
    private StudyDirectionDto studyDirection;
    private StatusDto status;
    private List<CompetenceDto> competencies;
}
