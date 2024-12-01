package com.gespyme.application.port.output;

import com.gespyme.application.usecase.FindCustomerByIdUseCase;
import com.gespyme.commons.exeptions.NotFoundException;
import com.gespyme.domain.model.Customer;
import com.gespyme.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdPort implements FindCustomerByIdUseCase {
    private final CustomerRepository repository;

    public Customer getCustomerById(String customerId) {
        Optional<Customer> customer = repository.findById(customerId);
        if (customer.isEmpty()) {
            throw new NotFoundException("Customer " + customerId + " not found");
        }
        return customer.get();
    }
}
