package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.CargoDto;
import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/cargos")
public class CargoController {
    private final CargoService cargoService;

    @GetMapping()
    public List<CargoDto> getAll() {
        return cargoService.getAll();
    }

    @GetMapping("/{id}")
    public CargoDto get(@PathVariable Long id) {
        return cargoService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody CargoDto cargoDto) {
        cargoService.create(cargoDto);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody CargoDto cargoDto) {
        cargoService.update(id, cargoDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        cargoService.delete(id);
    }
}
