package com.samsung.repository;

import com.samsung.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Modifying
    @Query("update Recipe c set c.content = :content where c.id = :id")
    void updateContentById(@Param("id") int id,
                           @Param("content") String content);

    List<Recipe> findByMealId(int id);

}
