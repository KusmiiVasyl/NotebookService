package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM Address a WHERE " +
            ":id = a.id " +
            "OR " +
            "lower(a.city) LIKE concat(lower(:city), '%') " +
            "OR " +
            "lower(a.street) LIKE concat(lower(:street), '%') " +
            "OR " +
            ":id IS null AND " +
            ":city IS null AND " +
            ":street IS null")
    Page<Address> findAllBy(Long id, String city, String street, Pageable pageable);
}
