package com.gespyme.application.port.input;

import com.gespyme.domain.model.Customer;
import com.gespyme.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerPort implements com.gespyme.application.usecase.CreateCustomerUseCase {
    private final CustomerRepository repository;

    public CreateCustomerPort(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }
}
