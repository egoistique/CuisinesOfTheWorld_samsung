package com.samsung.rest.controller;

import com.samsung.domain.Meal;
import com.samsung.rest.dto.MealDto;
import com.samsung.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @PostMapping("/meal")
    public MealDto createNewMeal(
            @RequestParam String nameMeal,
            @RequestParam String nameType,
            @RequestParam String nameTime,
            @RequestParam String nameCountry
    ) {

        Meal meal = mealService.insert(nameMeal, nameCountry, nameType, nameTime);
        return MealDto.toDto(meal);
    }

    @GetMapping("/meal")
    public List<MealDto> getAllMeals() {

        return mealService
                .getAll()
                .stream()
                .map(MealDto::toDto)
                .collect(Collectors.toList());
    }


    @PostMapping("/meal/{id}/")
    public MealDto updateMealById(
            @PathVariable int id,
            @RequestParam String newMealName,
            @RequestParam String newCountryName,
            @RequestParam String newTypeName,
            @RequestParam String newTimeName
    ) {

        Meal meal = mealService.update(
                id,
                newMealName,
                newCountryName,
                newTypeName,
                newTimeName
        );

        return MealDto.toDto(meal);
    }

    @GetMapping("/meal/{id}")
    public MealDto getMealById(@PathVariable int id) {

        return MealDto.toDto(mealService.getById(id));
    }

    @GetMapping("/meal/name")
    public MealDto getMealByName(@RequestParam String name) {

        return MealDto.toDto(mealService.getByName(name));
    }

    @DeleteMapping("/meal/{id}")
    //@PostMapping("/deleteBookById")
    public void deleteMealById(@PathVariable int id) {

        mealService.deleteById(id);
    }
}
