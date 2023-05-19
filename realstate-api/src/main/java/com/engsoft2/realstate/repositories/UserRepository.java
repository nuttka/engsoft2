package com.engsoft2.realstate.repositories;

import com.engsoft2.realstate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
