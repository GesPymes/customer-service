package com.gespyme.infrastructure.adapters.output.repository.jpa;

import com.gespyme.infrastructure.adapters.output.model.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositorySpringJpa extends JpaRepository<CustomerEntity, String>, QuerydslPredicateExecutor<CustomerEntity> {
}
