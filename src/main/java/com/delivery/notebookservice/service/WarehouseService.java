package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Warehouse;
import com.delivery.notebookservice.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

    public Warehouse get(Long id) {
        return warehouseRepository.findById(id).orElse(new Warehouse());
    }

    public void create(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    public void update(Long id, Warehouse warehouse) {
        Warehouse existingWarehouse = get(id);
        existingWarehouse.setTitle(warehouse.getTitle());
        existingWarehouse.setAddress(warehouse.getAddress());
        warehouseRepository.save(existingWarehouse);
    }


    public void delete(Long id) {
        warehouseRepository.deleteById(id);
    }
}
