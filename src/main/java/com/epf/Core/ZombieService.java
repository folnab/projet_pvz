package com.epf.Core;

import com.epf.Models.Zombie;
import com.epf.Persistance.ZombieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombieService {
    @Autowired
    private ZombieDAO repository;

    public List<Zombie> getAllZombies() {
        return repository.findAll();
    }

    public void addZombie(Zombie zombie) {
        if (zombie.getPointDeVie() <= 0) {
            throw new IllegalArgumentException("Un zombie sans vie ne peut pas combattre !");
        }
        repository.CreateZombie(zombie);
    }
}
