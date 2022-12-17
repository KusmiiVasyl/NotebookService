package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Transporter;
import com.delivery.notebookservice.service.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
