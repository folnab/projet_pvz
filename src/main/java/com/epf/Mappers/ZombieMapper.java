package com.epf.Mappers;

import com.epf.DTO.NewZombieDTO;
import com.epf.Models.Zombie;
import com.epf.DTO.ZombieDTO;

public class ZombieMapper {

    public static ZombieDTO toDTO(Zombie zombie) {
        ZombieDTO dto = new ZombieDTO();
        dto.setId_zombie(zombie.getIdZombie());
        dto.setNom(zombie.getNom());
        dto.setPoint_de_vie(zombie.getPointDeVie());
        dto.setAttaque_par_seconde(zombie.getAttaqueParSeconde());
        dto.setDegat_attaque(zombie.getDegatAttaque());
        dto.setVitesse_de_deplacement(zombie.getVitesseDeDeplacement());
        dto.setChemin_image(zombie.getCheminImage());
        dto.setId_map(zombie.getIdMap());
        return dto;
    }

    public static Zombie toModel(ZombieDTO dto) {
        return new Zombie(
                dto.getId_zombie(),
                dto.getNom(),
                dto.getPoint_de_vie(),
                dto.getAttaque_par_seconde(),
                dto.getDegat_attaque(),
                dto.getVitesse_de_deplacement(),
                dto.getChemin_image(),
                dto.getId_map() != null ? dto.getId_map() : 0 // ou gérer null différemment
        );
    }
    public static Zombie fromCreateDTOToModel(NewZombieDTO createDTO) {
        Zombie zombie = new Zombie();
        zombie.setNom(createDTO.getNom());
        zombie.setPointDeVie(createDTO.getPoint_de_vie());
        zombie.setAttaqueParSeconde(createDTO.getAttaque_par_seconde());
        zombie.setDegatAttaque(createDTO.getDegat_attaque());
        zombie.setVitesseDeDeplacement(createDTO.getVitesse_de_deplacement());
        zombie.setCheminImage(createDTO.getChemin_image());
        zombie.setIdMap(createDTO.getId_map());
        return zombie;
    }
}
