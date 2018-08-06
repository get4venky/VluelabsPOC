package com.support.cloud.function;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.domain.mapper.ScheduleDomainMapper;
import com.support.dto.ScheduleDto;
import com.support.service.ScheduleService;

@Component("scheduleFunction")
public class ScheduleFunction implements Function<ScheduleRequest, List<ScheduleDto>> {

    @Autowired
    private ScheduleService scheduleService;
    
    @Autowired
    private ScheduleDomainMapper scheduleDomainMapper;
    
    @Override
    public List<ScheduleDto> apply(ScheduleRequest request) {
        return scheduleDomainMapper.toDto(scheduleService.generateSchedule(request.getStartDate()));
    }

}
