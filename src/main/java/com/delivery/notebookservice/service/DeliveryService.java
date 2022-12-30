package com.delivery.notebookservice.service;

import com.delivery.notebookservice.dto.DeliveryDto;
import com.delivery.notebookservice.dto.DeliveryInfoDto;
import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.entity.Delivery;
import com.delivery.notebookservice.entity.Transporter;
import com.delivery.notebookservice.entity.Warehouse;
import com.delivery.notebookservice.entity.enums.DeliveryStatus;
import com.delivery.notebookservice.exception.EntityNotFoundException;
import com.delivery.notebookservice.mapper.Mapper;
import com.delivery.notebookservice.repository.CargoRepository;
import com.delivery.notebookservice.repository.DeliveryRepository;
import com.delivery.notebookservice.repository.TransporterRepository;
import com.delivery.notebookservice.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final WarehouseRepository warehouseRepository;
    private final TransporterRepository transporterRepository;
    private final CargoRepository cargoRepository;
    private final Mapper mapper;

    public Page<DeliveryInfoDto> getAll(Long id,
                                        Long warehouseFromId,
                                        String warehouseFromTitle,
                                        String deliveryFromCity,
                                        Long warehouseToId,
                                        String warehouseToTitle,
                                        String deliveryToCity,
                                        Long transporterId,
                                        Long cargoId,
                                        DeliveryStatus deliveryStatus,
                                        Pageable pageable) {
        return deliveryRepository.findAllBy(id,
                warehouseFromId,
                warehouseFromTitle,
                deliveryFromCity,
                warehouseToId,
                warehouseToTitle,
                deliveryToCity,
                transporterId,
                cargoId,
                deliveryStatus,
                pageable).map(mapper::toDeliveryInfoDto);
    }

    public DeliveryInfoDto get(Long id) {
        return deliveryRepository.findById(id).map(mapper::toDeliveryInfoDto).orElseThrow(EntityNotFoundException::new);
    }

    public void create(DeliveryDto deliveryDto) {
        Delivery delivery = new Delivery();
        deliveryDtoToDelivery(delivery, deliveryDto);
        deliveryRepository.save(delivery);
    }

    public void update(Long id, DeliveryDto deliveryDto) {
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        deliveryDtoToDelivery(delivery, deliveryDto);
        deliveryRepository.save(delivery);
    }

    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

    private void deliveryDtoToDelivery(Delivery delivery, DeliveryDto deliveryDto) {
        Warehouse warehouseFrom = warehouseRepository.findById(deliveryDto.getWarehouseFromId())
                .orElseThrow(EntityNotFoundException::new);
        Warehouse warehouseTo = warehouseRepository.findById(deliveryDto.getWarehouseToId())
                .orElseThrow(EntityNotFoundException::new);
        Transporter transporter = transporterRepository.findById(deliveryDto.getTransporterId())
                .orElseThrow(EntityNotFoundException::new);
        Cargo cargo = cargoRepository.findById(deliveryDto.getCargoId())
                .orElseThrow(EntityNotFoundException::new);
        delivery.setWarehouseFrom(warehouseFrom);
        delivery.setWarehouseTo(warehouseTo);
        delivery.setTransporter(transporter);
        delivery.setCargo(cargo);
        delivery.setDeliveryStatus(deliveryDto.getDeliveryStatus());
    }
}
