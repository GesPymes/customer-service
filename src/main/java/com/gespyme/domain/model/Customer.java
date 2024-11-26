package com.gespyme.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String customerId;
    private String name;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String email;
    private boolean needsInvoice;
}
