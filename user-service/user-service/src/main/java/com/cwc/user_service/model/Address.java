package com.cwc.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    private String street;
    private String suite;
    private String zipcode;
    private Geo geo;
}
