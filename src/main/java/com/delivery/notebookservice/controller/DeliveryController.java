package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.DeliveryDto;
import com.delivery.notebookservice.entity.Delivery;
import com.delivery.notebookservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping()
    public List<DeliveryDto> getAll() {
        return deliveryService.getAll();
    }

    @GetMapping("/{id}")
    public DeliveryDto get(@PathVariable Long id) {
        return deliveryService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody DeliveryDto deliveryDto) {
        deliveryService.create(deliveryDto);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody DeliveryDto deliveryDto) {
        deliveryService.update(id, deliveryDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        deliveryService.delete(id);
    }
}
