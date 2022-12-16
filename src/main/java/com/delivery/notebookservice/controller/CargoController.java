package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/cargo")
public class CargoController {
    private final CargoService cargoService;

    @GetMapping()
    public List<Cargo> getAll() {
        return cargoService.getAl();
    }

}
