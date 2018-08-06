package com.support.exception;

public class ScheduleGenerateException extends ApplicationException {
    
    public ScheduleGenerateException() {
        super(ErrorCode.SCHEDULE_GENERATE_ERROR, ErrorCode.SCHEDULE_GENERATE_ERROR_DESC);
    }

}
