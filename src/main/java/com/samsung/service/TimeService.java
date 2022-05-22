package com.samsung.service;

import com.samsung.domain.Time;
import com.samsung.domain.Type;

import java.util.List;

public interface TimeService {
    Time insert(Time time);

    Time update(int id, String newNameTime);

    List<Time> getAll();

    Time getById(int id);

    Time getByName(String nameTime);

    void deleteById(int id);
}
