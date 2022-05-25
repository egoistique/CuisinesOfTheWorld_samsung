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

    private final CountryService countryService;
    private final TypeService typeService;
    private final TimeService timeService;

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
    public Meal update(int id, String nameMeal, String nameType, String nameCountry, String nameTime) {
        Meal meal = Meal.builder()
                .id(id)
                .name(nameMeal)
                .country(countryService.getByName(nameCountry))
                .type(typeService.getByName(nameType))
                .time(timeService.getByName(nameTime))
                .build();

        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal getById(int id) {
        return mealRepository.getById(id);
    }

    @Override
    public Meal getByName(String name) {
        return mealRepository.findByName(name);
    }

    @Override
    public void deleteById(int id) {
        mealRepository.deleteById(id);
    }
}
