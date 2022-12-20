package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.exception.EntityNotFoundException;
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

    public Cargo get(Long id) {
        return cargoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void create(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    public void update(Long id, Cargo cargo) {
        Cargo existingCargo = get(id);
        existingCargo.setName(cargo.getName());
        existingCargo.setAmount(cargo.getAmount());
        cargoRepository.save(existingCargo);
    }

    public void delete(Long id) {
        cargoRepository.deleteById(id);
    }
}
