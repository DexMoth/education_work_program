package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.CurriculumDisciplineModel;
import org.work_program.models.CurriculumModel;

public interface CurriculumDisciplineRepository extends JpaRepository<CurriculumDisciplineModel, Long> {
}
