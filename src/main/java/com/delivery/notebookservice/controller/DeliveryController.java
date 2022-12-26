package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.DeliveryDto;
import com.delivery.notebookservice.dto.DeliveryInfoDto;
import com.delivery.notebookservice.service.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @Operation(summary = "Getting all deliveries.", description = "Getting all deliveries from database.")
    @GetMapping()
    public List<DeliveryInfoDto> getAll() {
        return deliveryService.getAll();
    }

    @Operation(summary = "Get delivery by id.", description = "Get delivery by id from database.")
    @GetMapping("/{id}")
    public DeliveryInfoDto get(@PathVariable Long id) {
        return deliveryService.get(id);
    }

    @Operation(summary = "Create delivery.",
            description = "To create a delivery, you need: " +
                    "insert the identifier of the corresponding object; " +
                    "set the delivery status from the corresponding list " +
                    "(ACCEPTED, REJECTED, LOADING, ON_WAY, UNLOADING, DELIVERED)")
    @PostMapping()
    private void create(@RequestBody DeliveryDto deliveryDto) {
        deliveryService.create(deliveryDto);
    }

    @Operation(summary = "Change delivery by id.",
            description = "To change the delivery, you need: " +
                    "change the identifier of the corresponding object; " +
                    "change the delivery status from the corresponding list " +
                    "(ACCEPTED, REJECTED, LOADING, ON_WAY, UNLOADING, DELIVERED)")
    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody DeliveryDto deliveryDto) {
        deliveryService.update(id, deliveryDto);
    }

    @Operation(summary = "Delete delivery by id.", description = "Delete delivery by id from database.")
    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        deliveryService.delete(id);
    }
}
