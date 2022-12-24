package com.delivery.notebookservice.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class AddressDto {
    private Long id;
    private String city;
    private String street;
    private double longitude;
    private double latitude;
}
