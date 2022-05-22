package com.samsung.rest.dto;

import com.samsung.domain.Meal;
import com.samsung.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {
    private int id;

    private String name;

    private CountryDto countryDto;

    private TypeDto typeDto;

    private TimeDto timeDto;

    private List<RecipeDto> recipeDto;

    public static Meal toDomainObject(MealDto gameDto, List<Recipe> recipes) {
        return new Meal(gameDto.getId(), gameDto.getName(),
                recipes,
                CountryDto.toDomainObject(gameDto.getCountryDto()),
                TypeDto.toDomainObject(gameDto.getTypeDto()),
                TimeDto.toDomainObject(gameDto.getTimeDto()));
    }

    public static MealDto toDto(Meal meal) {

        List<RecipeDto> commentDtoList;
        if (meal.getRecipes() != null) {
            commentDtoList = meal.getRecipes().stream().map(RecipeDto::toDto).collect(Collectors.toList());
        } else {
            commentDtoList = new ArrayList<>();
        }
        return new MealDto(
                meal.getId(),
                meal.getName(),
                CountryDto.toDto(meal.getCountry()),
                TypeDto.toDto(meal.getType()),
                TimeDto.toDto(meal.getTime()),
                commentDtoList);

    }
}
