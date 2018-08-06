package com.support.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    
    // Number of working days in schedule period
    public static int SCHEDULE_PERIOD_DAYS;
    
    // Engineers required each day
    public static int SCHEDULE_DAYS_ENGINEERS;
    
    // Engineer shifts
    public static int ENGINEER_SHIFT;
    
    @Value("${schedule.period.working.days}")
    public void setSchedulePeriodWorkingDays(int value) {
        SCHEDULE_PERIOD_DAYS = value;
    }
    
    @Value("${schedule.day.engineers}")
    public void setScheduleDayEngineers(int value) {
        SCHEDULE_DAYS_ENGINEERS = value;
    }
    
    @Value("${engineer.shift}")
    public void setEngineerShift(int value) {
        ENGINEER_SHIFT = value;
    }

}
