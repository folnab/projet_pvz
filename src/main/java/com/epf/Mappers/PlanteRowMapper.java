package com.epf.Mappers;

import com.epf.Models.Plante;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanteRowMapper implements RowMapper<Plante> {
    @Override
    public Plante mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Plante(
                rs.getInt("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getDouble("soleil_par_seconde"),
                rs.getString("effet"),
                rs.getString("chemin_image")
        );
    }
}
