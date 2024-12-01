package com.gespyme.infrastructure.mapper;

import com.gespyme.commons.model.customer.CustomerFilterModelApi;
import com.gespyme.commons.model.customer.CustomerModelApi;
import com.gespyme.domain.model.Customer;
import com.gespyme.domain.model.CustomerFilter;
import com.gespyme.infrastructure.adapters.output.model.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerInfrastructureMapper {
    CustomerFilter map(CustomerFilterModelApi customerFilterModelApi);

    Customer map(CustomerModelApi customerApiModel);

    List<CustomerModelApi> map(List<Customer> customers);

    CustomerModelApi map(Customer customers);

    List<Customer> mapEntityList(List<CustomerEntity> customerEntity);

    Customer map(CustomerEntity customerEntity);

    CustomerEntity mapToEntity(Customer customer);

    Customer merge(Customer newCustomerData, @MappingTarget Customer customer);

}
