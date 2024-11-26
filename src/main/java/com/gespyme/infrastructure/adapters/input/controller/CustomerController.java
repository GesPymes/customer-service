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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    private final ValidatorService<CustomerBaseModelApi> validator;


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerModelApi> getCustomerById(@PathVariable("customerId") String customerId) {
        validator.validateId(customerId);
        Customer customer = findCustomerByIdUseCase.getCustomerById(customerId);
        return ResponseEntity.ok(customerMapper.map(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerModelApi>> findCustomers(@RequestBody CustomerFilterModelApi customerFilterModelApi) {
        validator.validate(customerFilterModelApi, List.of(Validator.ONE_PARAM_NOT_NULL));
        CustomerFilter customerFilter = customerMapper.map(customerFilterModelApi);
        List<Customer> customers = findCustomersUseCase.findCustomer(customerFilter);
        return ResponseEntity.ok(customerMapper.map(customers));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") String customerId) {
        validator.validateId(customerId);
        deleteCustomerUseCase.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CustomerModelApi> createCustomer(@RequestBody CustomerModelApi CustomerModelApi) {
        validator.validate(CustomerModelApi, List.of(Validator.ALL_PARAMS_NOT_NULL));
        Customer customer = createCustomerUseCase.createCustomer(customerMapper.map(CustomerModelApi));
        URI location = URI.create("/customer/" + customer.getCustomerId());
        return ResponseEntity.created(location).body(customerMapper.map(customer));
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<CustomerModelApi> modifyCustomer(@PathVariable("customerId") String customerId, @RequestBody CustomerModelApi customerModelApi) {
        validator.validateId(customerId);
        validator.validate(customerModelApi, List.of(Validator.ONE_PARAM_NOT_NULL));
        Customer customer = modifyCustomersUseCase.modifyCustomer(customerId, customerMapper.map(customerModelApi));
        return ResponseEntity.ok(customerMapper.map(customer));
    }
}
