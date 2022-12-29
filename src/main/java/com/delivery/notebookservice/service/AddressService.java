package com.delivery.notebookservice.service;

import com.delivery.notebookservice.dto.AddressDto;
import com.delivery.notebookservice.exception.EntityNotFoundException;
import com.delivery.notebookservice.mapper.Mapper;
import com.delivery.notebookservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    private final Mapper mapper;

    public Page<AddressDto> getAll(Long id, String city, String street, Pageable pageable) {
        return addressRepository.findAllBy(id, city, street, pageable).map(mapper::toAddressDto);
    }

    public AddressDto get(Long id) {
        return addressRepository.findById(id).map(mapper::toAddressDto).orElseThrow(EntityNotFoundException::new);
    }

    public void create(AddressDto addressDto) {
        addressRepository.save(mapper.toAddress(addressDto));
    }

    @Transactional
    public void update(Long id, String city, String street, Double longitude, Double latitude) {
        addressRepository.updateAddressById(id, city, street, longitude, latitude);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
