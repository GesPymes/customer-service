package com.gespyme.application.port.output;

import com.gespyme.application.usecase.FindCustomersUseCase;
import com.gespyme.commons.model.filter.FieldFilter;
import com.gespyme.commons.repository.criteria.SearchCriteria;
import com.gespyme.domain.model.Customer;
import com.gespyme.domain.model.CustomerFilter;
import com.gespyme.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindCustomersPort implements FindCustomersUseCase {
    private final CustomerRepository customerRepository;
    private final List<FieldFilter<CustomerFilter>> customerFilters;

    public FindCustomersPort(CustomerRepository customerRepository, List<FieldFilter<CustomerFilter>> customerFilters) {
        this.customerRepository = customerRepository;
        this.customerFilters = customerFilters;
    }

    public List<Customer> findCustomer(CustomerFilter customerFilter) {
        List<SearchCriteria> searchCriterias = new ArrayList<>();
        customerFilters.stream().filter(f -> f.apply(customerFilter)).forEach(f -> f.addSearchCriteria(customerFilter, searchCriterias));
        return customerRepository.findByCriteria(searchCriterias);
    }
}
