package com.warehouse.api.dto;

public class WarehouseCreateDTO {

    private String nome;

    public WarehouseCreateDTO() {
    }
    public WarehouseCreateDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
