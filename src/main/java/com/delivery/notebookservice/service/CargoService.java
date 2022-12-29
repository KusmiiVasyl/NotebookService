package com.delivery.notebookservice.service;

import com.delivery.notebookservice.dto.CargoDto;
import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.exception.EntityNotFoundException;
import com.delivery.notebookservice.mapper.Mapper;
import com.delivery.notebookservice.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CargoService {
    private final CargoRepository cargoRepository;
    private final Mapper mapper;

    public Page<CargoDto> getAll(Long id, String name, Double amountRangeStart, Double amountRangeEnd, Pageable pageable) {
        return cargoRepository.findAllBy(id, name, amountRangeStart, amountRangeEnd, pageable).map(mapper::toCargoDto);
    }

    public CargoDto get(Long id) {
        return cargoRepository.findById(id).map(mapper::toCargoDto).orElseThrow(EntityNotFoundException::new);
    }

    public void create(CargoDto cargoDto) {
        cargoRepository.save(mapper.toCargo(cargoDto));
    }

    public void update(Long id, CargoDto cargoDto) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        cargo.setAmount(cargoDto.getAmount());
        cargoRepository.save(cargo);
    }

    public void delete(Long id) {
        cargoRepository.deleteById(id);
    }
}
