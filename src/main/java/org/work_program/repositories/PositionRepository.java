package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.PositionModel;

public interface PositionRepository extends JpaRepository<PositionModel, Long> {
}