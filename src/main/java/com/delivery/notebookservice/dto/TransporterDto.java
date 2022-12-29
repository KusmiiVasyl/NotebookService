package com.delivery.notebookservice.dto;

import lombok.Data;


@Data
public class TransporterDto {
    private Long id;
    private String name;
    private  String carModel;
    private double loadCapacity;
}
