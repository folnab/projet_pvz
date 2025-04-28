package com.epf.Core;

import com.epf.DTO.MapDTO;
import com.epf.DTO.NewMapDTO;
import com.epf.DTO.ZombieDTO;
import com.epf.Mappers.MapMapper;
import com.epf.Models.Map;
import com.epf.Models.Zombie;
import com.epf.Persistance.MapDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    private MapDAO dao;

    @Autowired
    private ZombieService zombieService;

    public List<MapDTO> getAllMaps() {
        List<Map> maps = dao.findAll();
        return maps.stream().map(MapMapper::toDTO).collect(Collectors.toList());
    }

    public MapDTO getMapById(int id) {
        return MapMapper.toDTO(dao.findById(id));
    }

    public MapDTO addMap(NewMapDTO newMap) {
        Map map= MapMapper.fromNewDTOToModel(newMap);
        int id = dao.createMap(map);
        map.setIdMap(id);
        return MapMapper.toDTO(map);
    }

    public void updateMap(int id, Map map) {
        map.setIdMap(id);
        dao.updateMap(map);
    }

    public void deleteMap(int id) {
        List<ZombieDTO> zombies = this.zombieService.getAllZombies();
        for(ZombieDTO zombie : zombies){
            if(zombie.getId_map()==id){
                zombieService.deleteZombie(zombie.getId_zombie());
            }
        }
        dao.deleteMap(id);
    }
}