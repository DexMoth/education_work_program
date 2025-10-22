package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.StatusModel;

public interface StatusRepository extends JpaRepository<StatusModel, Long> {
}

