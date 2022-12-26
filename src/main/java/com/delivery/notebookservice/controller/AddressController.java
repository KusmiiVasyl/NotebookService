package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.dto.AddressDto;
import com.delivery.notebookservice.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/adresses")
public class AddressController {
    private final AddressService addressService;

    @Operation(summary = "Getting all addresses.", description = "Getting all addresses from database.")
    @GetMapping()
    public List<AddressDto> getAll() {
        return addressService.getAll();
    }

    @Operation(summary = "Get address by id.", description = "Get address by id from database.")
    @GetMapping("/{id}")
    public AddressDto get(@PathVariable Long id) {
        return addressService.get(id);
    }

    @Operation(summary = "Create address.", description = "Create address and add to database.")
    @PostMapping()
    private void create(@RequestBody AddressDto addressDto) {
        addressService.create(addressDto);
    }

    @Operation(summary = "Change address by id.", description = "Change address by id in the database.")
    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        addressService.update(id, addressDto);
    }

    @Operation(summary = "Delete address by id.",
            description = "Delete address by id from database, if there is no warehouse at this address.")
    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
