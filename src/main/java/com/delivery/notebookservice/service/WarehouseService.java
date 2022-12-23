package com.delivery.notebookservice.service;

import com.delivery.notebookservice.dto.WarehouseDto;
import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.entity.Warehouse;
import com.delivery.notebookservice.exception.EntityNotFoundException;
import com.delivery.notebookservice.mapper.Mapper;
import com.delivery.notebookservice.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final Mapper mapper;

    public List<WarehouseDto> getAll() {
        return warehouseRepository.findAll().stream().map(mapper::toWarehouseDto).toList();
    }

    public WarehouseDto get(Long id) {
        return warehouseRepository.findById(id).map(mapper::toWarehouseDto).orElseThrow(EntityNotFoundException::new);
    }

    public void create(WarehouseDto warehouseDto) {
        warehouseRepository.save(mapper.toWarehouse(warehouseDto));
    }

    public void update(Long id, WarehouseDto warehouseDto) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        mapper.mergeWarehouse(warehouseDto, warehouse);
        warehouseRepository.save(warehouse);
    }

    public void delete(Long id) {
        warehouseRepository.deleteById(id);
    }
}
