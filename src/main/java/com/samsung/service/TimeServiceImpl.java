package com.samsung.service;

import com.samsung.domain.Time;
import com.samsung.domain.Type;
import com.samsung.repository.TimeRepository;
import com.samsung.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {
    private final TimeRepository timeRepository;

    @Override
    public Time insert(Time type) {
        return timeRepository.save(type);
    }

    @Override
    public Time update(int id, String newNameTime) {
        Time time = Time.builder()
                .id(id)
                .name(newNameTime)
                .build();
        return timeRepository.save(time);
    }

    @Override
    public List<Time> getAll() {
        return timeRepository.findAll();
    }

    @Override
    public Time getById(int id) {
        return timeRepository.findById(id).get();
    }

    @Override
    public Time getByName(String nameTime) {
        return timeRepository.findByName(nameTime);
    }

    @Override
    public void deleteById(int id) {
        timeRepository.deleteById(id);
    }
}
