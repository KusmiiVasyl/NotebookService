package com.delivery.notebookservice.mapper;

import com.delivery.notebookservice.dto.*;
import com.delivery.notebookservice.entity.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    AddressDto toAddressDto(Address address);
    Address toAddress(AddressDto addressDto);
    void mergeAddress(AddressDto addressDto, @MappingTarget Address address);

    @Mapping(source = "warehouse.address.city", target = "addressDto.city")
    @Mapping(source = "warehouse.address.street", target = "addressDto.street")
    @Mapping(source = "warehouse.address.longitude", target = "addressDto.longitude")
    @Mapping(source = "warehouse.address.latitude", target = "addressDto.latitude")
    WarehouseDto toWarehouseDto(Warehouse warehouse);
    @InheritInverseConfiguration
    Warehouse toWarehouse(WarehouseDto warehouseDto);
    @InheritInverseConfiguration
    void mergeWarehouse(WarehouseDto warehouseDto, @MappingTarget Warehouse warehouse);

    TransporterDto toTransporterDto(Transporter transporter);
    Transporter toTransporter(TransporterDto transporterDto);
    void mergeTransporter(TransporterDto transporterDto, @MappingTarget Transporter transporter);

    CargoDto toCargoDto(Cargo cargo);
    Cargo toCargo(CargoDto cargoDto);
    void mergeCargo(CargoDto cargoDto, @MappingTarget Cargo cargo);

    DeliveryInfoDto toDeliveryInfoDto(Delivery delivery);
}
