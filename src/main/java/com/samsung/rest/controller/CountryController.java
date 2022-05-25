package com.samsung.rest.controller;

import com.samsung.domain.Country;
import com.samsung.rest.dto.CountryDto;
import com.samsung.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping("/country")
    public CountryDto createNewCountry(@RequestBody CountryDto countryDto) {

        Country country = countryService.insert(CountryDto.toDomainObject(countryDto));
        return CountryDto.toDto(country);
    }

    @GetMapping("/country")
    public List<CountryDto> getAllCountries() {

        return countryService
                .getAll()
                .stream()
                .map(CountryDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/country/{id}")
    public CountryDto getCountryById(@PathVariable int id) {

        return CountryDto.toDto(countryService.getById(id));
    }

    @GetMapping("/country/name")
    public CountryDto getCountryByName(@RequestParam String name) {

        return CountryDto.toDto(countryService.getByName(name));
    }

    @PostMapping("/country/{id}/name")
    public CountryDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return CountryDto.toDto(
                countryService.update(id, name)
        );
    }

    @DeleteMapping("/country/{id}")
    public void deleteCountryById(@PathVariable int id) {

        countryService.deleteById(id);
    }
}
