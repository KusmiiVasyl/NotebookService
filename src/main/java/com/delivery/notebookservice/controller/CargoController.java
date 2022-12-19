package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.entity.Transporter;
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
    public List<Cargo> getAll() {
        return cargoService.getAll();
    }

    @GetMapping("/{id}")
    public Cargo get(@PathVariable Long id) {
        return cargoService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody Cargo cargo) {
        cargoService.create(cargo);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody Cargo cargo) {
        cargoService.update(id, cargo);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        cargoService.delete(id);
    }
}
