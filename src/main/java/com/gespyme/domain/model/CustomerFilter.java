package com.gespyme.domain.model;

import lombok.Data;

@Data
public class CustomerFilter {
    private String name;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String email;
    private Boolean needsInvoice;
}
