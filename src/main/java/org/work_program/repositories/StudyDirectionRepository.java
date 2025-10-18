package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.CompetenceIndicatorModel;
import org.work_program.models.StudyDirectionModel;

public interface StudyDirectionRepository extends JpaRepository<StudyDirectionModel, Long> {
}
