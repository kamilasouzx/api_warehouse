package com.warehouse.api.repository;

import com.warehouse.api.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepository extends
        JpaRepository<Warehouse, UUID> {
}
