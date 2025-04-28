package com.epf.Core;

import com.epf.DTO.NewPlanteDTO;
import com.epf.DTO.PlanteDTO;
import com.epf.Mappers.PlanteMapper;
import com.epf.Models.Plante;
import com.epf.Persistance.PlanteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanteService {

    @Autowired
    private PlanteDAO dao;

    public List<PlanteDTO> getAllPlantes() {
        List<Plante> plantes = dao.findAll();
        return plantes.stream().map(PlanteMapper::toDTO).collect(Collectors.toList());
    }

    public PlanteDTO getPlanteById(int id) {
        return PlanteMapper.toDTO(dao.findById(id));
    }

    public PlanteDTO addPlante(NewPlanteDTO newPlanteDTO) {
        if(newPlanteDTO.getPoint_de_vie()<=0){
            throw new IllegalArgumentException("Une plante sans vie ne peut pas combattre !");
        }
        Plante plante= PlanteMapper.fromNewDTOToModel(newPlanteDTO);
        int id = dao.createPlante(plante);
        plante.setId_plante(id);
        return PlanteMapper.toDTO(plante);
    }

    public void updatePlante(int id, PlanteDTO planteDTO) {
        Plante plante = PlanteMapper.toModel(planteDTO);
        plante.setId_plante(id);
        dao.updatePlante(plante);
    }

    public void deletePlante(int id) {
        dao.deletePlante(id);
    }
}
