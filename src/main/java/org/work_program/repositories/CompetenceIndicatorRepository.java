package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.CompetenceIndicatorModel;

public interface CompetenceIndicatorRepository extends JpaRepository<CompetenceIndicatorModel, Long> {
}
