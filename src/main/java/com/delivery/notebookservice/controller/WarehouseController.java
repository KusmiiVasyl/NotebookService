package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Warehouse;
import com.delivery.notebookservice.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Warehouse get(@PathVariable Long id) {
        return warehouseService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody Warehouse warehouse) {
        warehouseService.create(warehouse);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        warehouseService.update(id, warehouse);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        warehouseService.delete(id);
    }
}
