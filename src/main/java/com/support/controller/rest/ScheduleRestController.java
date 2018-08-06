package com.support.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.support.domain.Schedule;
import com.support.domain.mapper.ScheduleDomainMapper;
import com.support.exception.ApplicationException;
import com.support.service.ScheduleService;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleRestController {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    
    @Autowired
    private ScheduleService scheduleService;
    
    @Autowired
    private ScheduleDomainMapper scheduleDomainMapper;

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public ResponseEntity<?> get(@RequestParam(name="startDate", required=false, defaultValue="") String startDate)
        throws ApplicationException {
        
        logger.info("**** Request get schedule startDate[{}]", startDate);
        
        List<Schedule> schedules = null;
		if(startDate!=null && !startDate.isEmpty()) {
			schedules = scheduleService.generateSchedule(startDate);
			
		}else{
			
			return new ResponseEntity(schedules, HttpStatus.BAD_REQUEST);
		}
        
        logger.info("**** Response schedules[{}]", schedules);
        
        return new ResponseEntity(scheduleDomainMapper.toDto(schedules), HttpStatus.OK);
    }
}
