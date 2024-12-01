package com.gespyme.infrastructure.adapters.output.repository;

import com.gespyme.commons.repository.QueryField;
import com.gespyme.commons.repository.criteria.SearchCriteria;
import com.gespyme.domain.model.Customer;
import com.gespyme.domain.repository.CustomerRepository;
import com.gespyme.infrastructure.adapters.output.model.entities.CustomerEntity;
import com.gespyme.infrastructure.adapters.output.repository.jpa.CustomerRepositorySpringJpa;
import com.gespyme.infrastructure.mapper.CustomerInfrastructureMapper;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerJpaRepository implements CustomerRepository {
    private final Map<String, QueryField> queryFieldMap;
    private final CustomerRepositorySpringJpa customerRepositorySpringJpa;

    private final CustomerInfrastructureMapper mapper;

    public CustomerJpaRepository(List<QueryField> queryFields, CustomerRepositorySpringJpa customerRepositorySpringJpa, CustomerInfrastructureMapper mapper) {
        this.customerRepositorySpringJpa = customerRepositorySpringJpa;
        this.mapper = mapper;
        queryFieldMap = queryFields.stream().collect(Collectors.toMap(QueryField::getFieldName, queryField -> queryField));
    }

    @Override
    public List<Customer> findByCriteria(List<SearchCriteria> searchCriteria) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        searchCriteria.stream().forEach(sc -> queryFieldMap.get(sc.getKey()).addToQuery(booleanBuilder, sc));
        List<CustomerEntity> entities = (List<CustomerEntity>) customerRepositorySpringJpa.findAll(booleanBuilder);
        return mapper.mapEntityList(entities);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepositorySpringJpa.findById(id).map(mapper::map);
    }

    @Override
    public void deleteById(String id) {
        customerRepositorySpringJpa.deleteById(id);
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerRepositorySpringJpa.save(mapper.mapToEntity(customer));
        return mapper.map(customerEntity);
    }

    @Override
    public Customer merge(Customer newCustomerData, Customer customer) {
        Customer merged = mapper.merge(newCustomerData, customer);
        CustomerEntity savedEntity = customerRepositorySpringJpa.save(mapper.mapToEntity(merged));
        return mapper.map(savedEntity);
    }
}
