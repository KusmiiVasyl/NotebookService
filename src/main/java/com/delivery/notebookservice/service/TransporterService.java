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

    public Transporter get(Long id) {
        return transporterRepository.findById(id).orElse(new Transporter());
    }

    public void create(Transporter transporter) {
        transporterRepository.save(transporter);
    }

    public void update(Long id, Transporter transporter) {
        Transporter existingTransporter = get(id);
        existingTransporter = transporter.clone();
        transporterRepository.save(existingTransporter);
    }

    public void delete(Long id) {
        transporterRepository.deleteById(id);
    }
}
