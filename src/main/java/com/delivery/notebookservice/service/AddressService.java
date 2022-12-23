package com.delivery.notebookservice.service;

import com.delivery.notebookservice.dto.AddressDto;
import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.exception.EntityNotFoundException;
import com.delivery.notebookservice.mapper.Mapper;
import com.delivery.notebookservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    private final Mapper mapper;

    public List<AddressDto> getAll() {
        return addressRepository.findAll().stream().map(mapper::toAddressDto).toList();
    }

    public AddressDto get(Long id) {
        return addressRepository.findById(id).map(mapper::toAddressDto).orElseThrow(EntityNotFoundException::new);
    }

    public void create(AddressDto addressDto) {
        addressRepository.save(mapper.toAddress(addressDto));
    }

    public void update(Long id, AddressDto addressDto) {
        Address address = addressRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        mapper.mergeAddress(addressDto, address);
        addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
