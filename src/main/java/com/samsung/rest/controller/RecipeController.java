package com.samsung.rest.controller;

import com.samsung.domain.Recipe;
import com.samsung.rest.dto.RecipeDto;
import com.samsung.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/recipe")
    public RecipeDto createNewComment(
            @RequestParam String content,
            @RequestParam int mealId
    ) {

        Recipe comment = recipeService.insert(content, mealId);

        return RecipeDto.toDto(comment);
    }

    @GetMapping("/recipe")
    public List<RecipeDto> getAllComments() {

        return recipeService
                .getAll()
                .stream()
                .map(RecipeDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/recipe/{id}/content")
    public void updateCommentById(
            @PathVariable int id,
            @RequestParam String content
    ) {

        recipeService.update(id, content);
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteCommentById(@PathVariable int id) {

        recipeService.deleteById(id);
    }

    @GetMapping("/meal/{id}/recipe")
    public List<RecipeDto> getCommentsByMealIdId(@PathVariable int id) {

        return recipeService
                .getByMealId(id)
                .stream()
                .map(RecipeDto::toDto)
                .collect(Collectors.toList());
    }
}
