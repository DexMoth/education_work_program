package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.work_program.models.CompetenceIndicatorModel;
import org.work_program.models.DisciplineModel;

import java.util.Optional;


public interface DisciplineRepository extends JpaRepository<DisciplineModel, Long> {

    @Query("SELECT d FROM DisciplineModel d " +
            "LEFT JOIN FETCH d.competencies c " +
            "LEFT JOIN FETCH c.indicators " +
            "WHERE d.id = :id")
    Optional<DisciplineModel> findByIdWithCompetencesAndIndicators(@Param("id") Long id);
}
