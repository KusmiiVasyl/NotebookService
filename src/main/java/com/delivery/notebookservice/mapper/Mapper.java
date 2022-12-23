package com.delivery.notebookservice.mapper;

import com.delivery.notebookservice.dto.*;
import com.delivery.notebookservice.entity.*;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    AddressDto toAddressDto(Address address);
    Address toAddress(AddressDto addressDto);
    void mergeAddress(AddressDto addressDto, @MappingTarget Address address);

    @Mapping(source = "warehouse.address.city", target = "city")
    @Mapping(source = "warehouse.address.street", target = "street")
    @Mapping(source = "warehouse.address.longitude", target = "longitude")
    @Mapping(source = "warehouse.address.latitude", target = "latitude")
    WarehouseDto toWarehouseDto(Warehouse warehouse);
    Warehouse toWarehouse(WarehouseDto warehouseDto);
    void mergeWarehouse(WarehouseDto warehouseDto, @MappingTarget Warehouse warehouse);

    TransporterDto toTransporterDto(Transporter transporter);
    Transporter toTransporter(TransporterDto transporterDto);
    void mergeTransporter(TransporterDto transporterDto, @MappingTarget Transporter transporter);

    CargoDto toCargoDto(Cargo cargo);
    Cargo toCargo(CargoDto cargoDto);
    void mergeCargo(CargoDto cargoDto, @MappingTarget Cargo cargo);

    DeliveryDto toDeliveryDto(Delivery delivery);
    Delivery toDelivery(DeliveryDto deliveryDto);
    void mergeDelivery(DeliveryDto deliveryDto, @MappingTarget Delivery delivery);
}
