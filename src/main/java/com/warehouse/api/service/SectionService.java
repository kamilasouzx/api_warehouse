package com.warehouse.api.service;

import com.warehouse.api.dto.SectionCreateDTO;
import com.warehouse.api.entity.Section;
import com.warehouse.api.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public SectionCreateDTO findById(UUID id) {
        //retorna um section
        Section section = sectionRepository.findById(id).orElseThrow();
        //metodo para converter um section entity em sectionCreateDTO
        SectionCreateDTO sectionCreateDTO = convertToDTO(section);
        return sectionCreateDTO;
    }
    //metodo para salvar um section
    public SectionCreateDTO save(SectionCreateDTO sectionCreateDTO) {
        Section section = convertToEntity(sectionCreateDTO);
        section = sectionRepository.save(section);
        return convertToDTO(section);
    }
    //metodo para atualizar um section
    public SectionCreateDTO update(UUID id, SectionCreateDTO sectionCreateDTO) {
        Section section = convertToEntity(sectionCreateDTO);
        section.setId(id);
        section = sectionRepository.save(section);
        return convertToDTO(section);
    }

    //metodo para deletar um section
    public void deleteById(UUID id) {
        sectionRepository.deleteById(id);
    }

    //metodo para listar todos os sections
    public List<SectionCreateDTO> findAll() {
        List<Section> sections = sectionRepository.findAll();
        //criar lista de sectionsCreateDTO
        List<SectionCreateDTO> sectionCreateDTOs = new ArrayList<>();
        //para cada section na lista de sections, converter para DTO e add
        for (Section section : sections) {
            sectionCreateDTOs.add(convertToDTO(section));
        }
        return sectionCreateDTOs;
    }

    public SectionCreateDTO convertToDTO(Section section) {
        SectionCreateDTO sectionCreateDTO = new SectionCreateDTO();
        sectionCreateDTO.setCodigo(section.getCodigo());
        return sectionCreateDTO;
    }

    public Section convertToEntity(SectionCreateDTO sectionCreateDTO) {
        Section section = new Section();
        section.setCodigo(sectionCreateDTO.getCodigo());
        return section;
    }
}
