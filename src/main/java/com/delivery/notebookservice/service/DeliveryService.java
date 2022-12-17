package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Delivery;
import com.delivery.notebookservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }
}
