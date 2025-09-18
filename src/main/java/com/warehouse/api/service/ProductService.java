package com.warehouse.api.service;

import com.warehouse.api.dto.ProductCreateDTO;
import com.warehouse.api.entity.Product;
import com.warehouse.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired

    private ProductRepository productRepository;

    public ProductCreateDTO convertToDto(Product product) {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setNome(product.getNome());;
        productCreateDTO.setSku(product.getSku());
        return productCreateDTO;
    }

    public Product convertToEntity(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setNome(productCreateDTO.getNome());
        product.setSku(productCreateDTO.getSku());
        return product;
    }

    public ProductCreateDTO findById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductCreateDTO productCreateDTO = convertToDto(product);
        return productCreateDTO;
    }

    public ProductCreateDTO save(ProductCreateDTO productCreateDTO) {
        Product product = convertToEntity(productCreateDTO);
        product = productRepository.save(product);
        return convertToDto(product);
    }

    public ProductCreateDTO update(UUID id, ProductCreateDTO productCreateDTO) {
        Product product = convertToEntity(productCreateDTO);
        product.setId(id);
        product = productRepository.save(product);
        return convertToDto(product);
    }

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    public List<ProductCreateDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductCreateDTO> productDTO = new ArrayList<>();
        for (Product product : products) {
            productDTO.add(convertToDto(product));
        }
        return productDTO;
    }
}
