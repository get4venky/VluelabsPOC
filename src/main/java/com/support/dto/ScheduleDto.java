package com.support.dto;

import java.util.List;

import lombok.Data;

@Data
public class ScheduleDto {
    
    private String date;
    
    private List<EngineerDto> engineers;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<EngineerDto> getEngineers() {
		return engineers;
	}

	public void setEngineers(List<EngineerDto> engineers) {
		this.engineers = engineers;
	}
    
    

}
