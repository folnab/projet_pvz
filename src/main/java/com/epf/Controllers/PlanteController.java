package com.epf.Controllers;

import com.epf.Core.PlanteService;
import com.epf.DTO.NewPlanteDTO;
import com.epf.DTO.PlanteDTO;
import com.epf.Mappers.PlanteMapper;
import com.epf.Models.Plante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    @Autowired
    private PlanteService service;

    @GetMapping
    public List<PlanteDTO> getAllPlantes() {
        return service.getAllPlantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanteDTO> getPlanteById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getPlanteById(id));
    }

    @PostMapping
    public ResponseEntity<String> addPlante(@RequestBody NewPlanteDTO newPlanteDTO) {
        try {
            service.addPlante(newPlanteDTO);
            return ResponseEntity.ok("Nouvelle plante ajouté !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlante(@PathVariable("id") int id, @RequestBody PlanteDTO plante) {
        service.updatePlante(id, plante);
        return ResponseEntity.ok("Plante mise à jour !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlante(@PathVariable("id") int id) {
        service.deletePlante(id);
        return ResponseEntity.ok("Plante supprimée !");
    }
}
