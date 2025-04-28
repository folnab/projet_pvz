package com.epf.Mappers;

import com.epf.Models.Plante;
import com.epf.DTO.PlanteDTO;
import com.epf.DTO.NewPlanteDTO;

public class PlanteMapper {

    public static PlanteDTO toDTO(Plante plante) {
        PlanteDTO dto = new PlanteDTO();
        dto.setId_plante(plante.getId_plante());
        dto.setNom(plante.getNom());
        dto.setPoint_de_vie(plante.getPoint_de_vie());
        dto.setAttaque_par_seconde(plante.getAttaque_par_seconde());
        dto.setDegat_attaque(plante.getDegat_attaque());
        dto.setCout(plante.getCout());
        dto.setSoleil_par_seconde(plante.getSoleil_par_seconde());
        dto.setEffet(plante.getEffet());
        dto.setChemin_image(plante.getChemin_image());
        return dto;
    }

    public static Plante toModel(PlanteDTO dto) {
        return new Plante(
                dto.getId_plante(),
                dto.getNom(),
                dto.getPoint_de_vie(),
                dto.getAttaque_par_seconde(),
                dto.getDegat_attaque(),
                dto.getCout(),
                dto.getSoleil_par_seconde(),
                dto.getEffet(),
                dto.getChemin_image()
        );
    }

    public static Plante fromNewDTOToModel(NewPlanteDTO newDto) {
        Plante plante = new Plante();
        plante.setNom(newDto.getNom());
        plante.setPoint_de_vie(newDto.getPoint_de_vie());
        plante.setAttaque_par_seconde(newDto.getAttaque_par_seconde());
        plante.setDegat_attaque(newDto.getDegat_attaque());
        plante.setCout(newDto.getCout());
        plante.setSoleil_par_seconde(newDto.getSoleil_par_seconde());
        plante.setEffet(newDto.getEffet());
        plante.setChemin_image(newDto.getChemin_image());
        return plante;
    }
}
