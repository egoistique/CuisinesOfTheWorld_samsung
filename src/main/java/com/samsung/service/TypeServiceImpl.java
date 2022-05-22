package com.samsung.service;

import com.samsung.domain.Country;
import com.samsung.domain.Type;
import com.samsung.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService{

    private final TypeRepository typeRepository;

    @Override
    public Type insert(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type update(int id, String newNameType) {
        Type type = Type.builder()
                .id(id)
                .name(newNameType)
                .build();
        return typeRepository.save(type);
    }

    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type getById(int id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type getByName(String nameCountry) {
        return typeRepository.findByName(nameCountry);
    }

    @Override
    public void deleteById(int id) {
        typeRepository.deleteById(id);
    }
}
