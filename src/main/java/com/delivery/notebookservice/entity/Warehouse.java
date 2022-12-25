package com.delivery.notebookservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "warehouseFrom")
    private List<Delivery> deliveriesFrom;

    @OneToMany(mappedBy = "warehouseTo")
    private List<Delivery> deliveriesTo;
}
