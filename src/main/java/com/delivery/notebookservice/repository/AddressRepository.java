package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("""
            SELECT a FROM Address a WHERE 
            (:id = a.id OR :id IS null) AND 
            (lower(a.city) LIKE concat(lower(:city), '%') OR :city IS null) AND
            (lower(a.street) LIKE concat(lower(:street), '%') OR :street IS null)""")
    Page<Address> findAllBy(Long id, String city, String street, Pageable pageable);

    @Modifying
    @Query("""
            UPDATE Address a SET 
            a.city = :city, 
            a.street = :street, 
            a.longitude = :longitude, 
            a.latitude = :latitude 
            WHERE a.id = :id""")
    void updateAddressById(Long id, String city, String street, Double longitude, Double latitude);
}
