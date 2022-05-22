package com.samsung.repository;

import com.samsung.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByName(String name);
}
