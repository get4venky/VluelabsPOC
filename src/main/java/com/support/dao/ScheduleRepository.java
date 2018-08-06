package com.support.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.support.domain.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
