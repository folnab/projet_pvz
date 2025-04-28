package com.epf.Core;

import com.epf.DTO.ZombieDTO;
import com.epf.DTO.NewZombieDTO;
import com.epf.Mappers.ZombieMapper;
import com.epf.Models.Zombie;
import com.epf.Persistance.ZombieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZombieService {
    @Autowired
    private ZombieDAO repository;

    public List<ZombieDTO> getAllZombies() {
        List<Zombie> zombies = repository.findAll();
        return zombies.stream()
                .map(ZombieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ZombieDTO addZombie(NewZombieDTO zombieDto) {
        if (zombieDto.getPoint_de_vie() <= 0) {
            throw new IllegalArgumentException("Un zombie sans vie ne peut pas combattre !");
        }
        Zombie zombie=ZombieMapper.fromCreateDTOToModel(zombieDto);
        int id = repository.CreateZombie(zombie);
        zombie.setIdZombie(id);
        return ZombieMapper.toDTO(zombie);
    }

    public ZombieDTO getZombieById(int id) {
        return ZombieMapper.toDTO(repository.findById(id));
    }

    public void updateZombie(int id, ZombieDTO zombie) {
        Zombie zombieUpdate=ZombieMapper.toModel(zombie);
        zombieUpdate.setIdZombie(id);
        repository.updateZombie(zombieUpdate);
    }

    public void deleteZombie(int id) {
        repository.deleteZombie(id);
    }
}
