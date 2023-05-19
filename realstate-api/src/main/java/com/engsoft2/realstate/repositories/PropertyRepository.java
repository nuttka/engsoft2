package com.engsoft2.realstate.repositories;

import com.engsoft2.realstate.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
