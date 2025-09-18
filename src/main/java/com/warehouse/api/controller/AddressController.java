package com.warehouse.api.controller;

import com.warehouse.api.dto.AddressCreateDTO;
import com.warehouse.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    AddressService service;

    //    pegar um address pelo seu id5
    @GetMapping("/{id}")
    public AddressCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }

    //    pegar todos os addresses
    @GetMapping
    public List<AddressCreateDTO> findAll() {
        return service.findAll();
    }

    //    salvar um address
    @PostMapping
    public AddressCreateDTO save(@RequestBody AddressCreateDTO addressCreateDTO) {
        return service.save(addressCreateDTO);
    }

    //    atualizar um address
    @PutMapping("/{id}")
    public AddressCreateDTO update(@PathVariable("id") UUID id, @RequestBody AddressCreateDTO addressCreateDTO) {
        return service.update(id, addressCreateDTO);
    }

    //    deletar um address pelo seu id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
