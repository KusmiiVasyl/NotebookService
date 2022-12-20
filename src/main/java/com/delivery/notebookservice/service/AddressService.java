package com.delivery.notebookservice.service;

import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.exception.EntityNotFoundException;
import com.delivery.notebookservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address get(Long id) {
        return addressRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void create(Address address) {
        addressRepository.save(address);
    }

    public void update(Long id, Address address) {
        Address existingAddress = get(id);
        existingAddress.setCity(address.getCity());
        existingAddress.setStreet(address.getStreet());
        existingAddress.setLongitude(address.getLongitude());
        existingAddress.setLatitude(address.getLatitude());
        addressRepository.save(existingAddress);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
