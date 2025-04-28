package com.epf.Controllers;

import com.epf.Core.ZombieService;
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
    public ResponseEntity<String> addZombie(@RequestBody Zombie zombie) {
        try {
            service.addZombie(zombie);
            return ResponseEntity.ok("Nouveau zombie ajouté !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
