package com.gespyme.application.port.input;

import com.gespyme.application.usecase.DeleteCustomerUseCase;
import com.gespyme.commons.exeptions.NotFoundException;
import com.gespyme.domain.model.Customer;
import com.gespyme.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteCustomerPort implements DeleteCustomerUseCase {
    private final CustomerRepository repository;

    public void deleteCustomer(String customerId) {
        Optional<Customer> customer = repository.findById(customerId);
        if (customer.isEmpty()) {
            throw new NotFoundException("Customer " + customerId + " not found");
        }
        repository.deleteById(customerId);
    }
}
