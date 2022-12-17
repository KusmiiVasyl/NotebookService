package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Delivery;
import com.delivery.notebookservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping()
    public List<Delivery> getAll() {
        return deliveryService.getAll();
    }

}
