package com.samsung.service;

import com.samsung.domain.Country;
import com.samsung.domain.Meal;
import com.samsung.domain.Time;
import com.samsung.domain.Type;
import com.samsung.repository.CountryRepository;
import com.samsung.repository.MealRepository;
import com.samsung.repository.TimeRepository;
import com.samsung.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService{

    private final CountryRepository countryRepository;
    private final TypeRepository typeRepository;
    private final TimeRepository timeRepository;
    private final MealRepository mealRepository;

    @Override
    @Transactional
    public Meal insert(String nameMeal, String nameCountry, String nameType, String nameTime) {
        Country country = countryRepository.findByName(nameCountry);
        if (country == null) {
            country = Country.builder().name(nameCountry).build();
        }
        Type type = typeRepository.findByName(nameType);
        if (type == null) {
            type = Type.builder().name(nameType).build();
        }
        Time time = timeRepository.findByName(nameTime);
        if (time == null) {
            time = Time.builder().name(nameTime).build();
        }
        Meal meal = Meal.builder().name(nameMeal).country(country).type(type).time(time).build();
        return mealRepository.save(meal);
    }

    @Override
    @Transactional
    public Meal update(int id, String nameBook, String nameType, String nameCountry, String nameTime) {
        return null;
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal getById(int id) {
        return null;
    }

    @Override
    public Meal getByName(String name) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
