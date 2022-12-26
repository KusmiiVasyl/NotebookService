package com.delivery.notebookservice.dto;

import lombok.Data;


@Data
public class WarehouseDto {
    private Long id;
    private String title;
    private AddressDto addressDto;
}
