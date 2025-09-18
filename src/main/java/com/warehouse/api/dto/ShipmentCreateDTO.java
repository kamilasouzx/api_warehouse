package com.warehouse.api.dto;

import com.warehouse.api.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class ShipmentCreateDTO {

    private String status;
    private Set<Product> products = new HashSet<>();

    public ShipmentCreateDTO() {
    }

    public ShipmentCreateDTO(String status, Set<Product> products) {
        this.status = status;
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


