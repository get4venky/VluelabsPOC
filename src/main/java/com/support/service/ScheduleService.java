package com.support.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.common.Constant;
import com.support.common.Util;
import com.support.domain.Engineer;
import com.support.domain.Schedule;
import com.support.exception.ScheduleGenerateException;
import com.support.exception.ScheduleInvalidException;
import com.support.pool.EngineerPool;

@Service
public class ScheduleService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    
    private LinkedHashMap<Engineer, Integer> engineerMap = new LinkedHashMap<>();
    
    @Autowired
    private EngineerPool engineerPool;
    
    public List<Schedule> generateSchedule(String strStartDate) {
        
        try {
            
            Date startDate;
            if (strStartDate==null || strStartDate.equals("")) { // if empty then use today's date
                startDate = new Date();
            } else {    // parse date
                startDate = Util.parseDate(strStartDate);
            }
            
            // calculate schedule dates
            List<Date> scheduleDates = Util.calculateWorkingDates(startDate, Constant.SCHEDULE_PERIOD_DAYS);
            logger.info("Schedule dates [{}]", scheduleDates);
            
            List<Schedule> schedules;
            while (true) {
                try {
                    schedules = new ArrayList<>();
                    for (Date scheduleDate: scheduleDates) {
                        Schedule schedule = new Schedule();
                        schedule.setDate(scheduleDate);
                        List<Engineer> shiftEngineers = new ArrayList<>();
                        for (int i=1; i<=Constant.SCHEDULE_DAYS_ENGINEERS; i++) {
                            Engineer engineer = this.pickAndValidateEngineer(schedules, shiftEngineers);
                            shiftEngineers.add(engineer);
                        }
                        schedule.setEngineers(shiftEngineers);
                        schedules.add(schedule);
                    }
                    break;
                } catch (ScheduleInvalidException ex) {
                    this.engineerMap.clear();
                    continue;
                }
            }
            return schedules;
            
        } catch (Exception ex) {
            logger.error("Error occured while generating schedule. ", ex);
            ex.printStackTrace();
            throw new ScheduleGenerateException();
        }
        
    }
    
    private Engineer pickAndValidateEngineer(List<Schedule> currentSchedule, List<Engineer> currentShiftEngineers) 
            throws ScheduleInvalidException {
        
        Engineer selectedEngineer = null;
        Set<Engineer> invalidEngineer = new HashSet<>();
        
        while (true) {
            
            Engineer pickedEngineer = engineerPool.getRandom();
            
            if (invalidEngineer.size()==engineerPool.getSize()) {
                break;
            }
            
            // Rule: Each engineer should have completed one whole day of support in any 2 week period
            if (engineerMap.get(pickedEngineer)!=null && engineerMap.get(pickedEngineer)==Constant.ENGINEER_SHIFT) {
                invalidEngineer.add(pickedEngineer);
                continue;
            }
            
            // Rule: An engineer can do at most one half day shift in a day
            if (currentShiftEngineers.contains(pickedEngineer)) {
                invalidEngineer.add(pickedEngineer);
                continue;
            }
            
            // Rule: An engineer cannot have half day shifts on consecutive days
            if (currentSchedule.size()>0 && currentSchedule.get(currentSchedule.size()-1).getEngineers().contains(pickedEngineer)) {
                invalidEngineer.add(pickedEngineer);
                continue;
            }
            
            selectedEngineer = pickedEngineer;
            break;
        }
        
        if (selectedEngineer==null) {
            throw new ScheduleInvalidException();
        }
        
        if (this.engineerMap.get(selectedEngineer)!=null) {
            this.engineerMap.put(selectedEngineer, this.engineerMap.get(selectedEngineer)+1);
        } else {
            this.engineerMap.put(selectedEngineer, 1);
        }
        return selectedEngineer;
        
    }
    
}
