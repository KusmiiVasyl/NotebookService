package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Delivery;
import com.delivery.notebookservice.exception.EntityNotFoundException;
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

    public Delivery get(Long id) {
        return deliveryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void create(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public void update(Long id, Delivery delivery) {
        Delivery existingDelivery = get(id);
        existingDelivery.setWarehouseFrom(delivery.getWarehouseFrom());
        existingDelivery.setWarehouseTo(delivery.getWarehouseTo());
        existingDelivery.setTransporter(delivery.getTransporter());
        existingDelivery.setCargo(delivery.getCargo());
        existingDelivery.setStatusOfDelivery(delivery.getStatusOfDelivery());
        deliveryRepository.save(existingDelivery);
    }

    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }
}
