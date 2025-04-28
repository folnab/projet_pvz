package com.epf.Mappers;

import com.epf.Models.Map;
import com.epf.DTO.MapDTO;
import com.epf.DTO.NewMapDTO;

public class MapMapper {

    public static MapDTO toDTO(Map map) {
        MapDTO dto = new MapDTO();
        dto.setId_map(map.getIdMap());
        dto.setLigne(map.getLigne());
        dto.setColonne(map.getColonne());
        dto.setChemin_image(map.getCheminImage());
        return dto;
    }

    public static Map toModel(MapDTO dto) {
        return new Map(
                dto.getId_map(),
                dto.getLigne(),
                dto.getColonne(),
                dto.getChemin_image()
        );
    }

    public static Map fromNewDTOToModel(NewMapDTO newDto) {
        Map map = new Map();
        map.setLigne(newDto.getLigne());
        map.setColonne(newDto.getColonne());
        map.setCheminImage(newDto.getChemin_image());
        return map;
    }
}
