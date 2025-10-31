package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.work_program.models.CompetenceIndicatorModel;
import org.work_program.models.TeacherModel;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
    Optional<TeacherModel> findByLoginIgnoreCase(String login);

    @Query("SELECT t FROM TeacherModel t " +
            "LEFT JOIN FETCH t.position " +
            "LEFT JOIN FETCH t.department " +
            "WHERE t.id = :id")
    Optional<TeacherModel> findByIdWithRelations(@Param("id") Long id);
}