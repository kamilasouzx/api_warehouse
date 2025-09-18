package com.warehouse.api.dto;

public class ProductCreateDTO {
    private String sku;
    private String nome;

    public ProductCreateDTO() {
    }
    public ProductCreateDTO(String sku, String nome) {
        this.sku = sku;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}

