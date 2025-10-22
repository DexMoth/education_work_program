package org.work_program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work_program.models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
