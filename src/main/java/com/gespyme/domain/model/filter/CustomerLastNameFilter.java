package com.gespyme.domain.model.filter;

import com.gespyme.domain.model.CustomerFilter;
import com.gespyme.domain.model.criteria.SearchCriteria;
import com.querydsl.core.BooleanBuilder;

import java.util.List;

public class CustomerLastNameFilter implements CustomerFieldFilter {

    @Override
    public boolean apply(CustomerFilter customerFilter) {
        return false;
    }

    @Override
    public void addSearchCriteria(CustomerFilter customerFilter, List<SearchCriteria> searchCriteriaList) {

    }
}
