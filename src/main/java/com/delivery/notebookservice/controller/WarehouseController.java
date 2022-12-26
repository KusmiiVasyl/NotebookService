package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.WarehouseAddressDto;
import com.delivery.notebookservice.dto.WarehouseDto;
import com.delivery.notebookservice.service.WarehouseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @Operation(summary = "Getting all warehouses.", description = "Getting all warehouses from database.")
    @GetMapping()
    public List<WarehouseDto> getAll() {
        return warehouseService.getAll();
    }

    @Operation(summary = "Get warehouse by id.", description = "Get warehouse by id from database.")
    @GetMapping("/{id}")
    public WarehouseDto get(@PathVariable Long id) {
        return warehouseService.get(id);
    }

    @Operation(summary = "Create warehouse.",
            description = "To create a warehouse, you need: " +
                    "set name of warehouse and insert the identifier of address.")
    @PostMapping()
    private void create(@RequestBody WarehouseAddressDto warehouseAddressDto) {
        warehouseService.create(warehouseAddressDto);
    }

    @Operation(summary = "Change warehouse by id.",
            description = "To change the warehouse, you need: " +
                    "change name of warehouse or change the identifier of address.")
    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody WarehouseAddressDto warehouseAddressDto) {
        warehouseService.update(id, warehouseAddressDto);
    }

    @Operation(summary = "Delete warehouse by id.",
            description = "Delete warehouse by id only if it is not in delivery.")
    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        warehouseService.delete(id);
    }
}
