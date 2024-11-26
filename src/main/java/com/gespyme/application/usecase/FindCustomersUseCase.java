package com.gespyme.application.usecase;

import com.gespyme.domain.model.Customer;
import com.gespyme.domain.model.CustomerFilter;

import java.util.List;

public interface FindCustomersUseCase {
    List<Customer> findCustomer(CustomerFilter customerFilter);
}
