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
    public MealDto createNewGame(
            @RequestParam String nameGame,
            @RequestParam String nameGenre, @RequestParam String release,
            @RequestParam String nameCompany
    ) {

        Meal game = mealService.insert(nameGame, nameCompany, nameGenre, release);
        return MealDto.toDto(game);
    }

    @GetMapping("/meal")
    public List<MealDto> getAllGames() {

        return mealService
                .getAll()
                .stream()
                .map(MealDto::toDto)
                .collect(Collectors.toList());
    }


    @PostMapping("/meal/{id}/")
    public MealDto updateBookById(
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
    public MealDto getGameById(@PathVariable int id) {

        return MealDto.toDto(mealService.getById(id));
    }

    @GetMapping("/meal/name")
    public MealDto getGameByName(@RequestParam String name) {

        return MealDto.toDto(mealService.getByName(name));
    }

    @DeleteMapping("/meal/{id}")
    //@PostMapping("/deleteBookById")
    public void deleteGameById(@PathVariable int id) {

        mealService.deleteById(id);
    }
}
