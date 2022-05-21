package com.samsung.service;

import com.samsung.domain.Country;
import com.samsung.domain.Meal;
import com.samsung.domain.Recipe;
import com.samsung.repository.CountryRepository;
import com.samsung.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CusDemoService {

    private final CountryRepository countryRepository;
    private final MealRepository mealRepository;

    public void countryDemo(){
        List<Country> all = countryRepository.findAll();

        System.out.println("=====================");
        for (Country country : all){
            System.out.println(country);
        }

        System.out.println("=====================");

        Country country = Country.builder()
                .name("Германия")
                .build();

        countryRepository.save(country);

        all = countryRepository.findAll();

        System.out.println("=====================");
        for (Country country1 : all){
            System.out.println(country1);
        }

        System.out.println("=====================");
    }

    @Transactional
    public void mealDemo(){
        List<Meal> mealList = mealRepository.findAll();

//        Meal m = Meal.builder()
//                .name("Новая книга")
//                .country(countryRepository.findByName("Новый Автор"))
//                .type(genreDao.findByName("Новый Жанр"))
//                .time(genreDao.findByName("Новый Жанр"))
//                .build();

//        mealRepository.save(m);

        System.out.println("======Все книги======");

        for (Meal meal : mealList) {

            System.out.println(
                    meal.getName() + " : " +
                            meal.getCountry().getName() + ", " +
                            meal.getType().getName() + ", " +
                            meal.getTime().getName()
            );

            List<Recipe> recipeList = meal.getRecipes();

            for (Recipe recipe : recipeList){
                System.out.println(recipe.getContent());
            }

        }

        System.out.println("======================\n");
    }
}
