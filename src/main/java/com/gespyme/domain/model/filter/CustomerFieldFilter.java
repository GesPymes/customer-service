package com.gespyme.domain.model.filter;

import com.gespyme.domain.model.CustomerFilter;
import com.gespyme.domain.model.criteria.SearchCriteria;

import java.util.List;


public interface CustomerFieldFilter {

    boolean apply(CustomerFilter customerFilter);

    void addSearchCriteria(CustomerFilter customerFilter, List<SearchCriteria> searchCriteriaList);
}
