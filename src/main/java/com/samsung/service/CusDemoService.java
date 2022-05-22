package com.samsung.service;

import com.samsung.domain.*;
import com.samsung.repository.MealRepository;
import com.samsung.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CusDemoService implements CusDemo{

    private final CountryService countryService;
    private final MealService mealService;
    private final TypeService typeService;
    private final TimeService timeService;
    private final RecipeService recipeService;

    @Transactional
    public void countryDemo() {

        Country newCompany = Country.builder()
                .name("Новая Компания")
                .build();

        countryService.insert(newCompany);
//        companyService.update(1, "Ivan", "Rus", 2, 4);
        System.out.println("======Все компании======");

        for (Country company : countryService.getAll()) {

            System.out.println(company);
        }

        System.out.println("======================\n");
    }

    @Override
    @Transactional
    public void typeDemo() {

        Type newType = Type.builder()
                .name("Новый Жанр")
                .build();

//        genreService.insert(newGenre);

        System.out.println("======Все жанры======");

        for (Type type : typeService.getAll()) {

            System.out.println(type);
        }

        System.out.println("======================\n");
    }

    @Override
    @Transactional
    public void timeDemo() {

        Time newTime = Time.builder()
                .name("Новый Жанр")
                .build();

//        genreService.insert(newGenre);

        System.out.println("======Все жанры======");

        for (Time time : timeService.getAll()) {

            System.out.println(time);
        }

        System.out.println("======================\n");
    }

    @Transactional
    public void recipeDemo() {

        System.out.println("======Все отзывы======");

        for (Recipe recipe : recipeService.getAll()) {

            System.out.println(recipe.getMeal().getName() + " : " + recipe.getContent());
        }

        System.out.println("======================\n");
    }

    @Transactional
    public void mealDemo() {

        Meal meal = Meal.builder()
                .name("Новая игра")
                .country(countryService.getByName("Новая Компания"))
                .type(typeService.getByName("Новый Жанр"))
                .time(timeService.getByName("Новый Жанр"))
                .build();

        mealService.insert("CHEF", "Россия", "Мясо", "30 минут");
        System.out.println("======Все игры======");

        for (Meal meal1 : mealService.getAll()) {

            System.out.println(
                    meal1.getName() + " : " +
                            meal1.getCountry().getName() + ", " +
                            meal1.getType().getName()  + ", " +
                            meal1.getTime().getName()
            );
        }

        System.out.println("======================\n");

    }

    @Override
    @Transactional
    public void cusDemo() {

        countryDemo();
        mealDemo();
        typeDemo();
        timeDemo();
        recipeDemo();

    }
}
