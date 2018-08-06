package com.support.domain.mapper;

import java.util.List;

public abstract class DomainMapper<Domain, DTO> {
    
    public abstract DTO toDto(Domain domain);
    
    public abstract List<DTO> toDto(List<Domain> domains);
    
    public abstract Domain fromDto(DTO dto);
    
    public abstract List<Domain> fromDto(List<DTO> dtos);

}
