package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.CargoDto;
import com.delivery.notebookservice.service.CargoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/cargos")
public class CargoController {
    private final CargoService cargoService;

    @Operation(summary = "Getting all cargo.", description = "Getting all cargo from database.")
    @GetMapping()
    public Page<CargoDto> getAll(@RequestParam(required = false) Long id,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Double amountRangeStart,
                                 @RequestParam(required = false) Double amountRangeEnd,
                                 @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5)
                                 @ParameterObject Pageable pageable) {
        return cargoService.getAll(id, name, amountRangeStart, amountRangeEnd, pageable);
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
