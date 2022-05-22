package com.samsung.rest.dto;

import com.samsung.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private int id;

    private String name;


    public static Country toDomainObject(CountryDto countryDto) {
        return new Country(
                countryDto.getId(),
                countryDto.getName());
    }

    public static CountryDto toDto(Country countryDto) {
        return new CountryDto(countryDto.getId(),
                countryDto.getName());
    }
}


