package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.WorkProgramModel;

public interface WorkProgramRepository extends JpaRepository<WorkProgramModel, Long> {
}
