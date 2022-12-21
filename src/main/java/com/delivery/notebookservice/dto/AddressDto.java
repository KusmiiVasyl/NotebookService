package com.delivery.notebookservice.dto;

import lombok.Data;


@Data
public class AddressDto {
    private Long id;
    private String city;
    private String street;
    private double longitude;
    private double latitude;
}
