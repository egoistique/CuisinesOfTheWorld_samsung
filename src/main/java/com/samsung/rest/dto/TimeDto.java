package com.samsung.rest.dto;

import com.samsung.domain.Time;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TimeDto {
    private int id;
    private String name;

    public static Time toDomainObject(TimeDto timeDto) {

        return new Time(timeDto.getId(), timeDto.getName());
    }

    public static TimeDto toDto(Time time) {

        return new TimeDto(time.getId(), time.getName());
    }
}
