package com.warehouse.api.service;

import com.warehouse.api.dto.AddressCreateDTO;
import com.warehouse.api.entity.Address;
import com.warehouse.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressCreateDTO findById(UUID id) {
        //retorna um address
        Address address = addressRepository.findById(id).orElseThrow();
        //metodo para converter um address entity em addressCreateDTO
        AddressCreateDTO addressCreateDTO = convertToDTO(address);
        return addressCreateDTO;
    }
    //metodo para salvar um address
    public AddressCreateDTO save(AddressCreateDTO addressCreateDTO) {
        Address address = convertToEntity(addressCreateDTO);
        address = addressRepository.save(address);
        return convertToDTO(address);
    }
    //metodo para atualizar um address
    public AddressCreateDTO update(UUID id, AddressCreateDTO addressCreateDTO) {
        Address address = convertToEntity(addressCreateDTO);
        address.setId(id);
        address = addressRepository.save(address);
        return convertToDTO(address);
    }

    //metodo para deletar um address
    public void deleteById(UUID id) {
        addressRepository.deleteById(id);
    }

    //metodo para listar todos os addresses
    public List<AddressCreateDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        //criar lista de addressCreateDTO
        List<AddressCreateDTO> addressCreateDTOs = new ArrayList<>();
        //para cada address na lista de addresses, converter para DTO e add
        for (Address address : addresses) {
            addressCreateDTOs.add(convertToDTO(address));
        }
        return addressCreateDTOs;
    }

    public AddressCreateDTO convertToDTO(Address address) {
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setRua(address.getRua());
        addressCreateDTO.setCidade(address.getCidade());
        return addressCreateDTO;
    }

    public Address convertToEntity(AddressCreateDTO addressCreateDTO) {
        Address address = new Address();
        address.setRua(addressCreateDTO.getRua());
        address.setCidade(addressCreateDTO.getCidade());
        return address;
    }
}
