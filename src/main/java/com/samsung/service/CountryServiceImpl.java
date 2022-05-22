package com.samsung.service;

import com.samsung.domain.Country;
import com.samsung.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;

    @Override
    public Country insert(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country update(int id, String newNameCountry) {
        Country country = Country.builder()
                .id(id)
                .name(newNameCountry)
                .build();
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(int id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public Country getByName(String nameCountry) {
        return countryRepository.findByName(nameCountry);
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }
}
