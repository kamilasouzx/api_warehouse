package com.warehouse.api.controller;

import com.warehouse.api.dto.SectionCreateDTO;
import com.warehouse.api.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {
    @Autowired
    SectionService service;

    //    pegar uma section pelo seu id
    @GetMapping("/{id}")
    public SectionCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }

    //    pegar todas as sections
    @GetMapping
    public List<SectionCreateDTO> findAll() {
        return service.findAll();
    }

    //    salvar uma section
    @PostMapping
    public SectionCreateDTO save(@RequestBody SectionCreateDTO sectionCreateDTO) {
        return service.save(sectionCreateDTO);
    }

    //    atualizar uma section
    @PutMapping("/{id}")
    public SectionCreateDTO update(@PathVariable("id") UUID id, @RequestBody SectionCreateDTO sectionCreateDTO) {
        return service.update(id, sectionCreateDTO);
    }

    //    deletar uma section pelo seu id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
