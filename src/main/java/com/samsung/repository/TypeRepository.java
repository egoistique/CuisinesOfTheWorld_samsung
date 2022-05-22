package com.samsung.repository;

import com.samsung.domain.Country;
import com.samsung.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type findByName(String name);
}
