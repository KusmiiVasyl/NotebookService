package com.delivery.notebookservice.controller;

import com.delivery.notebookservice.entity.Address;
import com.delivery.notebookservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/notebookservice/adresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping()
    public List<Address> getAll() {
        return addressService.getAl();
    }

}
