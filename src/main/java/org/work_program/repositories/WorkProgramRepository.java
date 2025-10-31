package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.work_program.models.WorkProgramModel;

import java.util.List;
import java.util.Optional;

public interface WorkProgramRepository extends JpaRepository<WorkProgramModel, Long> {
    List<WorkProgramModel> findByTeacherId(Long teacherId);

    @Query("SELECT wp FROM WorkProgramModel wp WHERE wp.teacher.department.id = :departmentId")
    List<WorkProgramModel> findByDepartment(Long departmentId);

    @Query("SELECT wp FROM WorkProgramModel wp WHERE wp.curriculumDiscipline.curriculum.id = :curriculumId")
    List<WorkProgramModel> findByCurriculum(Long curriculumId);

    @Query("SELECT wp FROM WorkProgramModel wp WHERE wp.teacher.department.id = :departmentId AND wp.curriculumDiscipline.curriculum.id = :curriculumId")
    List<WorkProgramModel> findByDepartmentAndCurriculum(Long departmentId, Long curriculumId);

    @Query("SELECT wp FROM WorkProgramModel wp " +
            "LEFT JOIN FETCH wp.curriculumDiscipline cd " +
            "LEFT JOIN FETCH cd.curriculum " +
            "LEFT JOIN FETCH cd.discipline " +
            "WHERE wp.id = :id")
    Optional<WorkProgramModel> findByIdWithRelations(@Param("id") Long id);
}
