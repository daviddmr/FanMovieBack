package com.david.repository;

import com.david.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by david on 02/05/2017.
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
