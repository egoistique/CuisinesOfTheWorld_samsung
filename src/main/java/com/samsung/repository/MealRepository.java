package com.samsung.repository;

import com.samsung.domain.Meal;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    @Override
    @EntityGraph(attributePaths = {"country", "type", "time", "recipes"})
    List<Meal> findAll();
}
