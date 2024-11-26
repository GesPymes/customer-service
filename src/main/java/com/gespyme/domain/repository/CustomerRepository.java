package com.gespyme.domain.repository;

import com.gespyme.domain.model.Customer;
import com.gespyme.domain.model.criteria.SearchCriteria;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerRepository {
    List<Customer> findByCriteria(List<SearchCriteria> filters);
    Optional<Customer> findById(String id);
    void deleteById(String id);
    Customer save(Customer customer);
    Customer merge(Customer newCustomer, Customer customer);
}
