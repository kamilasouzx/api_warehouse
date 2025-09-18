package com.warehouse.api.dto;

import com.warehouse.api.entity.Address;
import com.warehouse.api.entity.Section;

import java.util.HashSet;
import java.util.Set;

public class WarehouseCreateDTO {

    private String nome;
    private Address address;
    private Set<Section> sections = new HashSet<>();

    public WarehouseCreateDTO() {
    }
    public WarehouseCreateDTO(String nome, Set<Section> sections, Address address) {
        this.nome = nome;
        this.sections = sections;
        this.address = address;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }
}
