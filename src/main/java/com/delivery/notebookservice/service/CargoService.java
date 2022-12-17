package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.repository.AddressRepository;
import com.delivery.notebookservice.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CargoService {
    private final CargoRepository cargoRepository;

    public List<Cargo> getAll() {
        return cargoRepository.findAll();
    }
}
