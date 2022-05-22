package com.samsung.service;

import com.samsung.domain.Country;

import java.util.List;

public interface CountryService {
    Country insert(Country country);

    Country update(int id, String newNameCountry);

    List<Country> getAll();

    Country getById(int id);

    Country getByName(String nameCountry);

    void deleteById(int id);
}
