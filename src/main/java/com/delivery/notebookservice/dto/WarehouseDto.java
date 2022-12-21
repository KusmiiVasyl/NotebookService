package com.delivery.notebookservice.dto;

import com.delivery.notebookservice.entity.Address;
import lombok.Data;


@Data
public class WarehouseDto {
    private Long id;
    private String title;
    private Address address;
}
