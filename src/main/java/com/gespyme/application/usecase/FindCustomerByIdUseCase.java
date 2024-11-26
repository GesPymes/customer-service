package com.gespyme.application.usecase;

import com.gespyme.domain.model.Customer;

public interface FindCustomerByIdUseCase {
    Customer getCustomerById(String customerId);
}
