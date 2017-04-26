package com.david.repository;

import com.david.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by david on 28/04/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> { }
