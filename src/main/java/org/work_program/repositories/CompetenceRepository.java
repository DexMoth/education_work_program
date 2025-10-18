package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.CompetenceModel;

public interface CompetenceRepository extends JpaRepository<CompetenceModel, Long> {
}
