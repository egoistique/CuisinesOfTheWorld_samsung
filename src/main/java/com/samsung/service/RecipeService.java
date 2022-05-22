package com.samsung.service;

import com.samsung.domain.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe insert(String content, int mealId);

    List<Recipe> getAll();

    Recipe getById(int id);

    List<Recipe> getByMealId(int id);

    void update(int id, String content);

    void deleteById(int id);
}
