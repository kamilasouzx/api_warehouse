package com.warehouse.api.dto;

public class SectionCreateDTO {

    private String codigo;

    public SectionCreateDTO() {
    }
    public SectionCreateDTO(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
