package com.epf.Controllers;

import com.epf.Core.MapService;
import com.epf.DTO.NewMapDTO;
import com.epf.Mappers.MapMapper;
import com.epf.Models.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapController {

    @Autowired
    private MapService service;

    @GetMapping
    public List<Map> getAllMaps() {
        return service.getAllMaps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getMapById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getMapById(id));
    }

    @PostMapping
    public ResponseEntity<String> addMap(@RequestBody NewMapDTO newMapDTO) {
        try {
            service.addMap(newMapDTO);
            return ResponseEntity.ok("Nouvelle plante ajouté !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMap(@PathVariable("id") int id, @RequestBody Map map) {
        service.updateMap(id, map);
        return ResponseEntity.ok("Map mise à jour !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMap(@PathVariable("id") int id) {
        service.deleteMap(id);
        return ResponseEntity.ok("Map supprimée !");
    }
}
