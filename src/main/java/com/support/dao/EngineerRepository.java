package com.support.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.support.domain.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Integer> {

}
