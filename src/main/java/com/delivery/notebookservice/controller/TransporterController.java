package com.delivery.notebookservice.controller;

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
    public List<Transporter> getAll() {
        return transporterService.getAll();
    }

    @GetMapping("/{id}")
    public Transporter get(@PathVariable Long id) {
        return transporterService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody Transporter transporter) {
        transporterService.create(transporter);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody Transporter transporter) {
        transporterService.update(id, transporter);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        transporterService.delete(id);
    }

}
