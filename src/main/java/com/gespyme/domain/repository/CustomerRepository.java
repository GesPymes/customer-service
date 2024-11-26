package com.gespyme.domain.repository;

import com.gespyme.commons.repository.GenericRepository;
import com.gespyme.commons.repository.criteria.SearchCriteria;
import com.gespyme.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerRepository extends GenericRepository<Customer> {
    List<Customer> findByCriteria(List<SearchCriteria> filters);
}
