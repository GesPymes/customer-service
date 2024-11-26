package com.gespyme.domain.model.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchCriteria {
    public String key;
    public SearchOperation operation;
    public Object value;
}