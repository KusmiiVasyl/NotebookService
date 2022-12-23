package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.AddressDto;
import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.mapper.Mapper;
import com.delivery.notebookservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/adresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping()
    public List<AddressDto> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressDto get(@PathVariable Long id) {
        return addressService.get(id);
    }

    @PostMapping()
    private void create(@RequestBody AddressDto addressDto) {
        addressService.create(addressDto);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        addressService.update(id, addressDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
