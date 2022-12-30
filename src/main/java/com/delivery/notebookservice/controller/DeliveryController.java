package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.DeliveryDto;
import com.delivery.notebookservice.dto.DeliveryInfoDto;
import com.delivery.notebookservice.entity.enums.DeliveryStatus;
import com.delivery.notebookservice.service.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @Operation(summary = "Getting all deliveries.", description = "Getting all deliveries from database.")
    @GetMapping()
    public Page<DeliveryInfoDto> getAll(@RequestParam(required = false) Long id,
                                        @RequestParam(required = false) Long warehouseFromId,
                                        @RequestParam(required = false) String warehouseFromTitle,
                                        @RequestParam(required = false) String deliveryFromCity,
                                        @RequestParam(required = false) Long warehouseToId,
                                        @RequestParam(required = false) String warehouseToTitle,
                                        @RequestParam(required = false) String deliveryToCity,
                                        @RequestParam(required = false) Long transporterId,
                                        @RequestParam(required = false) Long cargoId,
                                        @RequestParam(required = false) DeliveryStatus deliveryStatus,
                                        @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5)
                                        @ParameterObject Pageable pageable) {
        return deliveryService.getAll(id,
                warehouseFromId,
                warehouseFromTitle,
                deliveryFromCity,
                warehouseToId,
                warehouseToTitle,
                deliveryToCity,
                transporterId,
                cargoId,
                deliveryStatus,
                pageable);
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
