package com.samsung.service;

import com.samsung.domain.Meal;

import java.util.List;

public interface MealService {
    Meal insert(String name,
                String country,
                String type,
                String time);

    Meal update(int id,
                String nameBook,
                String nameType,
                String nameCountry,
                String nameTime);

    List<Meal> getAll();

    Meal getById(int id);

    Meal getByName(String name);

    void deleteById(int id);
}
