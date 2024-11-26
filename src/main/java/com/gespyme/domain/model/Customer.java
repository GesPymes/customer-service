package com.gespyme.domain.model;

import lombok.Data;

@Data
public class Customer {
    private String customerId;
    private String name;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String email;
    private boolean needsInvoice;
}
