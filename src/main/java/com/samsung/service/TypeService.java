package com.samsung.service;

import com.samsung.domain.Country;
import com.samsung.domain.Type;

import java.util.List;

public interface TypeService {
    Type insert(Type type);

    Type update(int id, String newNameType);

    List<Type> getAll();

    Type getById(int id);

    Type getByName(String nameType);

    void deleteById(int id);
}
