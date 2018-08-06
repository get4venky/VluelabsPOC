package com.support.domain.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.common.Util;
import com.support.domain.Schedule;
import com.support.dto.ScheduleDto;

@Component
public class ScheduleDomainMapper extends DomainMapper<Schedule, ScheduleDto> {

    @Autowired
    private EngineerDomainMapper engineerDomainMapper;
    
    @Override
    public ScheduleDto toDto(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setDate(Util.formatDate(schedule.getDate()));
        scheduleDto.setEngineers(engineerDomainMapper.toDto(schedule.getEngineers()));
        return scheduleDto;
    }

    @Override
    public List<ScheduleDto> toDto(List<Schedule> schedules) {
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        for (Schedule schedule: schedules) {
            scheduleDtos.add(this.toDto(schedule));
        }
        return scheduleDtos;
    }

    @Override
    public Schedule fromDto(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        try {
            schedule.setDate(Util.parseDate(scheduleDto.getDate()));
        } catch (ParseException e) {
            schedule.setDate(null);
        }
        schedule.setEngineers(engineerDomainMapper.fromDto(scheduleDto.getEngineers()));
        return schedule;
    }

    @Override
    public List<Schedule> fromDto(List<ScheduleDto> scheduleDtos) {
        List<Schedule> schedules = new ArrayList<>();
        for (ScheduleDto scheduleDto: scheduleDtos) {
            schedules.add(this.fromDto(scheduleDto));
        }
        return schedules;
    }

}
