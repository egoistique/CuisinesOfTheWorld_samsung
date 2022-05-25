package com.samsung.service;

import com.samsung.domain.Meal;
import com.samsung.domain.Recipe;
import com.samsung.repository.MealRepository;
import com.samsung.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final MealRepository mealRepository;

    @Override
    @Transactional
    public Recipe insert(String content, int mealId) {

        Meal meal = mealRepository.findById(mealId).orElse(null);

        Recipe recipe = Recipe.builder()
                .content(content)
                .meal(meal)
                .build();

        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAll() {

        return recipeRepository.findAll();
    }

    @Override
    public Recipe getById(int id) {

        return recipeRepository.getById(id);
    }

    @Override
    public List<Recipe> getByMealId(int id) {

        return recipeRepository.findByMealId(id);
    }

    @Override
    @Transactional
    public void update(int id, String content) {

        recipeRepository.updateContentById(id, content);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        recipeRepository.deleteById(id);
    }
}
