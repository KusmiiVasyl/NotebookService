package com.delivery.notebookservice.service;

import com.delivery.notebookservice.dto.TransporterDto;
import com.delivery.notebookservice.entity.Transporter;
import com.delivery.notebookservice.exception.EntityNotFoundException;
import com.delivery.notebookservice.mapper.Mapper;
import com.delivery.notebookservice.repository.TransporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TransporterService {
    private final TransporterRepository transporterRepository;
    private final Mapper mapper;

    public List<TransporterDto> getAll() {
        return transporterRepository.findAll().stream().map(mapper::toTransporterDto).toList();
    }

    public TransporterDto get(Long id) {
        return transporterRepository.findById(id).map(mapper::toTransporterDto).orElseThrow(EntityNotFoundException::new);
    }

    public void create(TransporterDto transporterDto) {
        transporterRepository.save(mapper.toTransporter(transporterDto));
    }

    public void update(Long id, TransporterDto transporterDto) {
        Transporter transporter = transporterRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        mapper.mergeTransporter(transporterDto, transporter);
        transporterRepository.save(transporter);
    }

    public void delete(Long id) {
        transporterRepository.deleteById(id);
    }
}
