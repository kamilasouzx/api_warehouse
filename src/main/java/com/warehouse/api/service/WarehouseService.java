package com.warehouse.api.service;

import com.warehouse.api.dto.WarehouseCreateDTO;
import com.warehouse.api.entity.Warehouse;
import com.warehouse.api.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseCreateDTO findById(UUID id) {
        //retorna um warehouse
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow();
        //metodo para converter um warehouse entity em warehouseCreateDTO
        WarehouseCreateDTO warehouseCreateDTO = convertToDTO(warehouse);
        return warehouseCreateDTO;
    }
    //metodo para salvar um warehouse
    public WarehouseCreateDTO save(WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse = warehouseRepository.save(warehouse);
        return convertToDTO(warehouse);
    }
    //metodo para atualizar um warehouse
    public WarehouseCreateDTO update(UUID id, WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse.setId(id);
        warehouse = warehouseRepository.save(warehouse);
        return convertToDTO(warehouse);
    }

    //metodo para deletar um warehouse
    public void deleteById(UUID id) {
        warehouseRepository.deleteById(id);
    }

    //metodo para listar todos os warehouses
    public List<WarehouseCreateDTO> findAll() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        //criar lista de warehousesCreateDTO
        List<WarehouseCreateDTO> warehouseCreateDTOs = new ArrayList<>();
        //para cada warehouse na lista de warehouses, converter para DTO e add
        for (Warehouse warehouse : warehouses) {
            warehouseCreateDTOs.add(convertToDTO(warehouse));
        }
        return warehouseCreateDTOs;
    }

    public WarehouseCreateDTO convertToDTO(Warehouse warehouse) {
        WarehouseCreateDTO warehouseCreateDTO = new WarehouseCreateDTO();
        warehouseCreateDTO.setNome(warehouse.getNome());
        warehouseCreateDTO.setSections(warehouse.getSections());
        return warehouseCreateDTO;
    }

    public Warehouse convertToEntity(WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = new Warehouse();
        warehouse.setNome(warehouseCreateDTO.getNome());
        warehouse.setSections(warehouseCreateDTO.getSections());
        return warehouse;
    }
}
