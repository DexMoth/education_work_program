package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.work_program.models.CurriculumDisciplineModel;
import org.work_program.models.CurriculumModel;

import java.util.List;
import java.util.Optional;

public interface CurriculumDisciplineRepository extends JpaRepository<CurriculumDisciplineModel, Long> {

    @Query("SELECT cd FROM CurriculumDisciplineModel cd WHERE cd.curriculum.id = :curriculumId")
    List<CurriculumDisciplineModel> findByCurriculumId(@Param("curriculumId") Long curriculumId);

    @Query("SELECT cd FROM CurriculumDisciplineModel cd " +
            "LEFT JOIN FETCH cd.curriculum c " +
            "LEFT JOIN FETCH c.studyForm " +
            "LEFT JOIN FETCH c.studyDirection " +
            "LEFT JOIN FETCH cd.discipline d " +
            "LEFT JOIN FETCH d.department " +
            "WHERE cd.id = :id")
    Optional<CurriculumDisciplineModel> findByIdWithRelations(@Param("id") Long id);
}
