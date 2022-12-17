package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.entity.Transporter;
import com.delivery.notebookservice.repository.CargoRepository;
import com.delivery.notebookservice.repository.TransporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TransporterService {
    private final TransporterRepository transporterRepository;

    public List<Transporter> getAll() {
        return transporterRepository.findAll();
    }
}
