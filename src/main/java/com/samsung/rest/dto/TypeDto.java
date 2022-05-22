package com.samsung.rest.dto;


import com.samsung.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {
    private int id;
    private String name;

    public static Type toDomainObject(TypeDto typeDto) {

        return new Type(typeDto.getId(), typeDto.getName());
    }

    public static TypeDto toDto(Type type) {

        return new TypeDto(type.getId(), type.getName());
    }

}
