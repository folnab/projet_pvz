package com.epf.Controllers;

import com.epf.Core.ZombieService;
import com.epf.DTO.NewZombieDTO;
import com.epf.DTO.ZombieDTO;
import com.epf.Models.Zombie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zombies")
public class ZombieController {
    @Autowired
    private ZombieService service;

    @GetMapping
    public List<Zombie> getAllZombies() {
        return service.getAllZombies();
    }

    @PostMapping
    public ResponseEntity<String> addZombie(@RequestBody NewZombieDTO zombie) {
        try {
            service.addZombie(zombie);
            return ResponseEntity.ok("Nouveau zombie ajouté !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zombie> getZombieById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getZombieById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombie) {
        try {
            service.updateZombie(id, zombie);
            return ResponseEntity.ok("Zombie mis à jour !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteZombie(@PathVariable("id") int id) {
        service.deleteZombie(id);
        return ResponseEntity.ok("Zombie supprimé !");
    }
}
