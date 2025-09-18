package com.warehouse.api.dto;

public class ShipmentCreateDTO {

    private String status;

    public ShipmentCreateDTO() {
    }

    public ShipmentCreateDTO(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
