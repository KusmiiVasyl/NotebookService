package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/adresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping()
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address get(@PathVariable Long id) {
        return addressService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody Address address) {
        addressService.create(address);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody Address address) {
        addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
