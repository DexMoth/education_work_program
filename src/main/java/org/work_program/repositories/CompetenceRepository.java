package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.work_program.models.CompetenceModel;

@Repository
public interface CompetenceRepository extends JpaRepository<CompetenceModel, Long> {
}
