package com.warehouse.api.controller;

import com.warehouse.api.dto.ProductCreateDTO;
import com.warehouse.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductService service;

    // pegar um product pelo seu id
    @GetMapping("/{id}")
    public ProductCreateDTO findById(@PathVariable("id") UUID id){
        return service.findById(id);
    }
    // pegar todos os products
    @GetMapping
    public List<ProductCreateDTO> findAll(){
        return service.findAll();
    }
    // salvar um product
    @PostMapping
    public ProductCreateDTO save(
            @RequestBody ProductCreateDTO productCreateDTO ){
        return service.save(productCreateDTO);
    }
    // atualizar um product
    @PutMapping("/{id}")
    public ProductCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody ProductCreateDTO productCreateDTO){
        return service.update(id,productCreateDTO);
    }
    // deletar um product pelo seu id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id){

        service.deleteById(id);
    }
}
