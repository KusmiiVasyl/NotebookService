package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.TransporterDto;
import com.delivery.notebookservice.entity.Transporter;
import com.delivery.notebookservice.service.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/transporters")
public class TransporterController {
    private final TransporterService transporterService;

    @GetMapping()
    public List<TransporterDto> getAll() {
        return transporterService.getAll();
    }

    @GetMapping("/{id}")
    public TransporterDto get(@PathVariable Long id) {
        return transporterService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody TransporterDto transporterDto) {
        transporterService.create(transporterDto);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody TransporterDto transporterDto) {
        transporterService.update(id, transporterDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        transporterService.delete(id);
    }

}
