package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.StudyFormModel;

public interface StudyFormRepository extends JpaRepository<StudyFormModel, Long> {
}