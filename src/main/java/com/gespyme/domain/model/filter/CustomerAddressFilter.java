package com.gespyme.domain.model.filter;

import com.gespyme.commons.model.filter.FieldFilter;
import com.gespyme.commons.repository.criteria.SearchCriteria;
import com.gespyme.commons.repository.criteria.SearchOperation;
import com.gespyme.domain.model.CustomerFilter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CustomerAddressFilter implements FieldFilter<CustomerFilter> {
    @Override
    public boolean apply(CustomerFilter customerFilter) {
        return Objects.nonNull(customerFilter.getAddress());
    }

    @Override
    public void addSearchCriteria(CustomerFilter customerFilter, List<SearchCriteria> searchCriteriaList) {
        searchCriteriaList.add(SearchCriteria.builder().key("address").operation(SearchOperation.LIKE).value(customerFilter.getAddress()).build());
    }
}
