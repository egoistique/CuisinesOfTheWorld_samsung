package com.samsung.rest.controller;

import com.samsung.domain.Time;
import com.samsung.rest.dto.TimeDto;
import com.samsung.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TimeController {
    private final TimeService timeService;

    @PostMapping("/time")
    public TimeDto createNewTime(@RequestBody TimeDto timeDto) {

        Time time = timeService.insert(TimeDto.toDomainObject(timeDto));
        return TimeDto.toDto(time);
    }

    @GetMapping("/time")
    public List<TimeDto> getAllTimes() {

        return timeService
                .getAll()
                .stream()
                .map(TimeDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/time/{id}")
    public TimeDto getTimeById(@PathVariable int id) {

        return TimeDto.toDto(timeService.getById(id));
    }

    @GetMapping("/time/name")
    public TimeDto getTimeByName(@RequestParam String name) {

        return TimeDto.toDto(timeService.getByName(name));
    }

    @PostMapping("/time/{id}/name")
    public TimeDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return TimeDto.toDto(
                timeService.update(id, name)
        );
    }

    @DeleteMapping("/time/{id}")
    public void deleteTimeById(@PathVariable int id) {

        timeService.deleteById(id);
    }
}
