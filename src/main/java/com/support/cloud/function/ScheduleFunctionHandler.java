package com.support.cloud.function;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.support.dto.ScheduleDto;

public class ScheduleFunctionHandler extends SpringBootRequestHandler<ScheduleRequest, List<ScheduleDto>> {

}
