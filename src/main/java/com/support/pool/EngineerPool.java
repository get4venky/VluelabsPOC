package com.support.pool;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.common.Util;
import com.support.dao.EngineerRepository;
import com.support.domain.Engineer;

@Component
public class EngineerPool {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    
    @Autowired
    private EngineerRepository engineerRepository;
    
    private List<Engineer> pool = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        
        logger.debug("Initializing EnginnerPool");
        this.pool = engineerRepository.findAll();
        logger.debug(pool.toString());
    }
    
    public Engineer getRandom() {
        int randomIndex = Util.getRandomNumber(pool.size());
        return this.pool.get(randomIndex);
    }
    
    public int getSize() {
        return this.pool.size();
    }
    
}
