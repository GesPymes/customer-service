package com.gespyme.infrastructure.adapters.input.controller;

import com.gespyme.application.usecase.*;
import com.gespyme.commons.model.customer.CustomerBaseModelApi;
import com.gespyme.commons.model.customer.CustomerFilterModelApi;
import com.gespyme.commons.model.customer.CustomerModelApi;
import com.gespyme.commons.validator.Validator;
import com.gespyme.commons.validator.ValidatorService;
import com.gespyme.domain.model.Customer;
import com.gespyme.domain.model.CustomerFilter;
import com.gespyme.infrastructure.mapper.CustomerInfrastructureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerInfrastructureMapper customerMapper;
    private final FindCustomersUseCase findCustomersUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final ModifyCustomersUseCase modifyCustomersUseCase;
    private final ValidatorService<CustomerBaseModelApi> validatorService;


    @GetMapping("/{customerId}")
    public CustomerModelApi getCustomerById(@PathVariable("customerId") String customerId) {
        validatorService.validateId(customerId);
        Customer customer = findCustomerByIdUseCase.getCustomerById(customerId);
        return customerMapper.map(customer);
    }

    @GetMapping
    public List<CustomerModelApi> findCustomers(CustomerFilterModelApi customerFilterModelApi) {
       CustomerFilter customerFilter =  customerMapper.map(customerFilterModelApi);
        List<Customer> customers = findCustomersUseCase.findCustomer(customerFilter);
        return customerMapper.map(customers);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String customerId) {
        validatorService.validateId(customerId);
        deleteCustomerUseCase.deleteCustomer(customerId);
    }

    @PostMapping
    public String createCustomer(@RequestBody CustomerModelApi customerApiModel) {
        validatorService.validate(customerApiModel, List.of(Validator.ALL_PARAMS_NOT_NULL));
        Customer customer = createCustomerUseCase.createCustomer(customerMapper.map(customerApiModel));
        return customer.getCustomerId();
    }

    @PatchMapping("/{customerId}")
    public CustomerModelApi modifyCustomer(@PathVariable("customerId") String customerId, @RequestBody CustomerModelApi customerApiModel) {
        validatorService.validate(customerApiModel, List.of(Validator.ONE_PARAM_NOT_NULL));
        Customer customer = modifyCustomersUseCase.modifyCustomer(customerId, customerMapper.map(customerApiModel));
        return customerMapper.map(customer);
    }
}
