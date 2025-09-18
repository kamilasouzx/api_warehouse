package com.warehouse.api.controller;

import com.warehouse.api.dto.WarehouseCreateDTO;
import com.warehouse.api.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService service;

    //    pegar um Warehouse pelo seu id
    @GetMapping("/{id}")
    public WarehouseCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }

    //    pegar todos os Warehouses
    @GetMapping
    public List<WarehouseCreateDTO> findAll() {
        return service.findAll();
    }

    //    salvar um Warehouse
    @PostMapping
    public WarehouseCreateDTO save(@RequestBody WarehouseCreateDTO warehouseCreateDTO) {
        return service.save(warehouseCreateDTO);
    }

    //    atualizar um warehouse
    @PutMapping("/{id}")
    public WarehouseCreateDTO update(@PathVariable("id") UUID id, @RequestBody WarehouseCreateDTO warehouseCreateDTO) {
        return service.update(id, warehouseCreateDTO);
    }

    //    deletar um warehouse pelo seu id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
