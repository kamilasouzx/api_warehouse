package com.warehouse.api.repository;

import com.warehouse.api.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectionRepository extends
        JpaRepository<Section, UUID> {
}