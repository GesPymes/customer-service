package com.gespyme.application.port.input;

import com.gespyme.application.usecase.ModifyCustomersUseCase;
import com.gespyme.commons.exeptions.NotFoundException;
import com.gespyme.domain.model.Customer;
import com.gespyme.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ModifyCustomersPort implements ModifyCustomersUseCase {
    private final CustomerRepository repository;

    public Customer modifyCustomer(String customerId, Customer newCustomerData) {
        Optional<Customer> customer = repository.findById(customerId);
        if (customer.isEmpty()) {
            throw new NotFoundException("Customer " + customerId + " not found");
        }
        return repository.merge(newCustomerData, customer.get());
    }
}
