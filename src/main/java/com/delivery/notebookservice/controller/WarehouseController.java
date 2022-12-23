package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.WarehouseCreateDto;
import com.delivery.notebookservice.dto.WarehouseDto;
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
    public List<WarehouseDto> getAll() {
        return warehouseService.getAll();
    }

    @GetMapping("/{id}")
    public WarehouseDto get(@PathVariable Long id) {
        return warehouseService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody WarehouseCreateDto warehouseCreateDto) {
        warehouseService.create(warehouseCreateDto);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody WarehouseCreateDto warehouseCreateDto) {
        warehouseService.update(id, warehouseCreateDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        warehouseService.delete(id);
    }
}
