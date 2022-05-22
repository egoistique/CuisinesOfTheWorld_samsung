package com.samsung.rest.controller;

import com.samsung.domain.Type;
import com.samsung.rest.dto.TypeDto;
import com.samsung.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @PostMapping("/type")
    public TypeDto createNewType(@RequestBody TypeDto typeDto) {

        Type type = typeService.insert(TypeDto.toDomainObject(typeDto));
        return TypeDto.toDto(type);
    }

    @GetMapping("/type")
    public List<TypeDto> getAllTypes() {

        return typeService
                .getAll()
                .stream()
                .map(TypeDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/type/{id}")
    public TypeDto getTypeById(@PathVariable int id) {

        return TypeDto.toDto(typeService.getById(id));
    }

    @GetMapping("/type/name")
    public TypeDto getTypeByName(@RequestParam String name) {

        return TypeDto.toDto(typeService.getByName(name));
    }

    @PostMapping("/type/{id}/name")
    public TypeDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return TypeDto.toDto(
                typeService.update(id, name)
        );
    }

    @DeleteMapping("/type/{id}")
    public void deleteTypeById(@PathVariable int id) {

        typeService.deleteById(id);
    }
}
