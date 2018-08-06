package com.support.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private Date date;
    
    
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public List<Engineer> getEngineers() {
		return engineers;
	}



	public void setEngineers(List<Engineer> engineers) {
		this.engineers = engineers;
	}



	@ManyToMany(mappedBy = "schedules")
    private List<Engineer> engineers;
}
