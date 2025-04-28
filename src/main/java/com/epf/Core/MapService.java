package com.epf.Core;

import com.epf.DTO.MapDTO;
import com.epf.DTO.NewMapDTO;
import com.epf.Mappers.MapMapper;
import com.epf.Models.Map;
import com.epf.Models.Zombie;
import com.epf.Persistance.MapDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    @Autowired
    private MapDAO dao;

    @Autowired
    private ZombieService zombieService;

    public List<Map> getAllMaps() {
        return dao.findAll();
    }

    public Map getMapById(int id) {
        return dao.findById(id);
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
        List<Zombie> zombies = this.zombieService.getAllZombies();
        for(Zombie zombie : zombies){
            if(zombie.getIdMap()==id){
                zombieService.deleteZombie(zombie.getIdZombie());
            }
        }
        dao.deleteMap(id);
    }
}