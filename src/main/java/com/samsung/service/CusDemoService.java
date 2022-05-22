package com.samsung.service;

import com.samsung.domain.Country;
import com.samsung.domain.Meal;
import com.samsung.domain.Recipe;
import com.samsung.repository.CountryRepository;
import com.samsung.repository.MealRepository;
import com.samsung.repository.RecipeRepository;
import liquibase.pro.packaged.M;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CusDemoService {

    private final CountryRepository countryRepository;
    private final RecipeRepository recipeRepository;
    private final MealRepository mealRepository;

    public void countryDemo() {
        List<Country> all = countryRepository.findAll();

        System.out.println("=====================");
        for (Country country : all) {
            System.out.println(country);
        }

        System.out.println("=====================");

        Country country = Country.builder()
                .name("Германия")
                .build();

        countryRepository.save(country);

        all = countryRepository.findAll();

        System.out.println("=====================");
        for (Country country1 : all) {
            System.out.println(country1);
        }

        System.out.println("=====================");

        System.out.println(countryRepository.findByName("Россия"));
    }

    @Transactional
    public void mealDemo() {
        List<Meal> mealList = mealRepository.findAll();

        System.out.println("======Все блюда======");

 //       for (Meal meal : mealList) {

//            System.out.println(
//                    meal.getName() + " : " +
//                            meal.getCountry().getName() + ", " +
//                            meal.getType().getName() + ", " +
//                            meal.getTime().getName()
//            );
//
//            List<Recipe> recipeList = meal.getRecipes();
//
//            for (Recipe recipe : recipeList){
//                System.out.println(recipe.getContent());
//            }

            List<Meal> mealList1 = mealRepository.findByName("Болоньезе");

            for (Meal meal1 : mealList1) {
                System.out.println(
                        meal1.getName() + " : " +
                                meal1.getCountry().getName() + ", " +
                                meal1.getType().getName() + ", " +
                                meal1.getTime().getName()
                );

                List<Recipe> recipeList = meal1.getRecipes();

                for (Recipe recipe : recipeList) {
                    System.out.println(recipe.getContent());
                }
            }

       // }


        System.out.println("======================\n");
    }

    @Transactional
    public void recipeDemo() {

        recipeRepository.updateContentById(1, "берем воду и кипятим");
        List<Recipe> recipeList = recipeRepository.findAll();

        System.out.println("======Все рецепты======");

        for (Recipe recipe : recipeRepository.findAll()) {

            System.out.println(recipe.getMeal().getName() + " : " + recipe.getContent());
            System.out.println(recipe.getId() + " - " + recipe.getContent());
        }

        System.out.println("======================\n");

        recipeList = recipeRepository.findByMealId(2);
        for (Recipe recipe : recipeRepository.findAll()) {

            System.out.println(recipe.getMeal().getName() + " : " + recipe.getContent());
            System.out.println(recipe.getId() + " - " + recipe.getContent());
        }
    }
}
