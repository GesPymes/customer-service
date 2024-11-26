package com.gespyme.application.usecase;

import com.gespyme.domain.model.Customer;

public interface ModifyCustomersUseCase {
    Customer modifyCustomer(String customerId, Customer newCustomerData);
}
