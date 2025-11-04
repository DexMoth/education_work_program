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

    @Query("SELECT wp FROM WorkProgramModel wp WHERE wp.curriculum.studyDirection.id = :studyDirectionId")
    List<WorkProgramModel> findByStudyDirection(Long studyDirectionId);

    @Query("SELECT wp FROM WorkProgramModel wp WHERE wp.teacher.department.id = :departmentId AND wp.curriculum.studyDirection.id = :studyDirectionId")
    List<WorkProgramModel> findByDepartmentAndStudyDirection(Long departmentId, Long studyDirectionId);

    @Query("SELECT wp FROM WorkProgramModel wp " +
            "LEFT JOIN FETCH wp.curriculum c " +
            "LEFT JOIN FETCH c.studyDirection " +
            "LEFT JOIN FETCH c.studyForm " +
            "LEFT JOIN FETCH wp.teacher " +
            "LEFT JOIN FETCH wp.status " +
            "WHERE wp.id = :id")
    Optional<WorkProgramModel> findByIdWithRelations(@Param("id") Long id);
}
