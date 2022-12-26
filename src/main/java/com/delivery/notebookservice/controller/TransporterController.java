package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.TransporterDto;
import com.delivery.notebookservice.service.TransporterService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/transporters")
public class TransporterController {
    private final TransporterService transporterService;

    @Operation(summary = "Getting all transporters.", description = "Getting all transporters from database.")
    @GetMapping()
    public List<TransporterDto> getAll() {
        return transporterService.getAll();
    }

    @Operation(summary = "Get transporter by id.", description = "Get transporter by id from database.")
    @GetMapping("/{id}")
    public TransporterDto get(@PathVariable Long id) {
        return transporterService.get(id);
    }

    @Operation(summary = "Create transporter.", description = "Create transporter and add to database.")
    @PostMapping()
    private void create(@RequestBody TransporterDto transporterDto) {
        transporterService.create(transporterDto);
    }

    @Operation(summary = "Change transporter by id.", description = "Change transporter by id in the database.")
    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody TransporterDto transporterDto) {
        transporterService.update(id, transporterDto);
    }

    @Operation(summary = "Delete transporter by id.",
            description = "Delete transporter by id only if it is not in delivery.")
    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        transporterService.delete(id);
    }
}
