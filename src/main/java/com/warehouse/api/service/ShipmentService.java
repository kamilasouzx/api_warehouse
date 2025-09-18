package com.warehouse.api.service;

import com.warehouse.api.dto.ShipmentCreateDTO;
import com.warehouse.api.entity.Shipment;
import com.warehouse.api.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public ShipmentCreateDTO findById(UUID id) {
        //retorna um shipment
        Shipment shipment = shipmentRepository.findById(id).orElseThrow();
        //metodo para converter um shipment entity em shipmentCreateDTO
        ShipmentCreateDTO shipmentCreateDTO = convertToDTO(shipment);
        return shipmentCreateDTO;
    }
    //metodo para salvar um shipment
    public ShipmentCreateDTO save(ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = convertToEntity(shipmentCreateDTO);
        shipment = shipmentRepository.save(shipment);
        return convertToDTO(shipment);
    }
    //metodo para atualizar um shipment
    public ShipmentCreateDTO update(UUID id, ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = convertToEntity(shipmentCreateDTO);
        shipment.setId(id);
        shipment = shipmentRepository.save(shipment);
        return convertToDTO(shipment);
    }

    //metodo para deletar um shipment
    public void deleteById(UUID id) {
        shipmentRepository.deleteById(id);
    }

    //metodo para listar todos os shipments
    public List<ShipmentCreateDTO> findAll() {
        List<Shipment> shipments = shipmentRepository.findAll();
        //criar lista de shipmentCreateDTO
        List<ShipmentCreateDTO> shipmentCreateDTOs = new ArrayList<>();
        //para cada shipment na lista de shipments, converter para DTO e add
        for (Shipment shipment : shipments) {
            shipmentCreateDTOs.add(convertToDTO(shipment));
        }
        return shipmentCreateDTOs;
    }

    public ShipmentCreateDTO convertToDTO(Shipment shipment) {
        ShipmentCreateDTO shipmentCreateDTO = new ShipmentCreateDTO();
        shipmentCreateDTO.setStatus(shipment.getStatus());

        return shipmentCreateDTO;
    }

    public Shipment convertToEntity(ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = new Shipment();
        shipment.setStatus(shipmentCreateDTO.getStatus());
        return shipment;
    }
}
