package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.CargoDto;
import com.delivery.notebookservice.service.CargoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/cargos")
public class CargoController {
    private final CargoService cargoService;

    @Operation(summary = "Getting all cargo.", description = "Getting all cargo from database.")
    @GetMapping()
    public List<CargoDto> getAll() {
        return cargoService.getAll();
    }

    @Operation(summary = "Get cargo by id.", description = "Get cargo by id from database.")
    @GetMapping("/{id}")
    public CargoDto get(@PathVariable Long id) {
        return cargoService.get(id);
    }

    @Operation(summary = "Create cargo.", description = "Create cargo and add to database.")
    @PostMapping()
    private void create(@RequestBody CargoDto cargoDto) {
        cargoService.create(cargoDto);
    }

    @Operation(summary = "Change cargo by id.", description = "Only the amount can be changed in the cargo.")
    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody CargoDto cargoDto) {
        cargoService.update(id, cargoDto);
    }

    @Operation(summary = "Delete cargo by id.",
            description = "Cargo can be deleted by id only if it is not in delivery.")
    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        cargoService.delete(id);
    }
}
