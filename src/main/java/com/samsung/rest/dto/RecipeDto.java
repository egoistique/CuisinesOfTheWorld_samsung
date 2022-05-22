package com.samsung.rest.dto;

import com.samsung.domain.Meal;
import com.samsung.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private int id;

    private String content;

    public static Recipe toDomainObject(RecipeDto recipeDto, Meal meal) {

        return new Recipe(recipeDto.getId(), recipeDto.getContent(), meal);
    }

    public static RecipeDto toDto(Recipe recipe) {

        return new RecipeDto(recipe.getId(), recipe.getContent());
    }
}
