package com.warehouse.api.repository;

import com.warehouse.api.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipmentRepository extends
        JpaRepository<Shipment, UUID> {
}