package com.delivery.notebookservice.dto;

import jakarta.persistence.Embedded;
import lombok.Data;


@Data
public class WarehouseDto {
    private Long id;
    private String title;

    @Embedded
    private AddressDto addressDto;
}
