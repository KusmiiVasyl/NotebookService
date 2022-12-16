package com.delivery.notebookservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private double longitude;
    private double latitude;

    @OneToMany (mappedBy = "address")
    private List<Warehouse> warehouses;
//    @OneToOne(mappedBy = "addressId")
//    private Warehouse warehouses;
}
