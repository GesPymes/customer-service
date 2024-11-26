package com.gespyme.domain.model.filter;

import com.gespyme.domain.model.CustomerFilter;
import com.gespyme.domain.model.criteria.SearchCriteria;
import com.gespyme.domain.model.criteria.SearchOperation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CustomerNameFilter implements CustomerFieldFilter {

    @Override
    public boolean apply(CustomerFilter customerFilter) {
        return Objects.nonNull(customerFilter.getName());
    }

    @Override
    public void addSearchCriteria(CustomerFilter customerFilter, List<SearchCriteria> searchCriteriaList) {
        searchCriteriaList.add(SearchCriteria.builder().key("name").operation(SearchOperation.LIKE).value(customerFilter.getName()).build());
    }
}
