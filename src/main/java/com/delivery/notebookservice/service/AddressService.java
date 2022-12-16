package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public List<Address> getAl() {
        return addressRepository.findAll();
    }
}
