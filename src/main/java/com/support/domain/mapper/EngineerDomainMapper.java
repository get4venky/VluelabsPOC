package com.support.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.support.domain.Engineer;
import com.support.dto.EngineerDto;

@Component
public class EngineerDomainMapper extends DomainMapper<Engineer, EngineerDto> {

    @Override
    public EngineerDto toDto(Engineer engineer) {
        EngineerDto engineerDto = new EngineerDto();
        engineerDto.setId(engineer.getId());
        engineerDto.setName(engineer.getName());
        return engineerDto;
    }

    @Override
    public List<EngineerDto> toDto(List<Engineer> engineers) {
        List<EngineerDto> engineerDtos = new ArrayList<>();
        for (Engineer engineer: engineers) {
            engineerDtos.add(this.toDto(engineer));
        }
        return engineerDtos;
    }

    @Override
    public Engineer fromDto(EngineerDto engineerDto) {
        Engineer engineer = new Engineer();
        engineer.setId(engineerDto.getId());
        engineer.setName(engineerDto.getName());
        return engineer;
    }

    @Override
    public List<Engineer> fromDto(List<EngineerDto> engineerDtos) {
        List<Engineer> engineers = new ArrayList<>();
        for (EngineerDto engineerDto: engineerDtos) {
            engineers.add(this.fromDto(engineerDto));
        }
        return engineers;
    }

}
