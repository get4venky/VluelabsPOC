package com.support.cloud.function;

import lombok.Data;

@Data
public class ScheduleRequest {

    private String startDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
    
    
    
}
