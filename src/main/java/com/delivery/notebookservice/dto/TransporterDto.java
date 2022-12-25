package com.delivery.notebookservice.dto;

import com.delivery.notebookservice.entity.Delivery;
import lombok.Data;

import java.util.List;


@Data
public class TransporterDto {
    private Long id;
    private String name;
    private  String carModel;
    private double loadCapacity;
}
