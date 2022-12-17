package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Warehouse;
import com.delivery.notebookservice.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping()
    public List<Warehouse> getAll() {
        return warehouseService.getAll();
    }

}
