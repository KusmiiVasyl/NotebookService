package com.delivery.notebookservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warehouse_from_id")
    private Warehouse warehouseFrom;

    @ManyToOne
    @JoinColumn(name = "warehouse_to_id")
    private Warehouse warehouseTo;

    @ManyToOne
    @JoinColumn(name = "transporter_id")
    private Transporter transporter;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    private StatusOfDelivery statusOfDelivery;
}
