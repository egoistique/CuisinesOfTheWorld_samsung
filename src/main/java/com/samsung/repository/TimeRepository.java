package com.samsung.repository;

import com.samsung.domain.Country;
import com.samsung.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Integer> {
    Time findByName(String name);
}
