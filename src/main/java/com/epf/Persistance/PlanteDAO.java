package com.epf.Persistance;

import com.epf.Models.Plante;
import com.epf.Mappers.PlanteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

@Repository
public class PlanteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Plante> findAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    public Plante findById(int id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new PlanteRowMapper(), id);
    }

    public int createPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id_plante"});
            ps.setString(1, plante.getNom());
            ps.setInt(2, plante.getPoint_de_vie());
            ps.setDouble(3, plante.getAttaque_par_seconde());
            ps.setInt(4, plante.getDegat_attaque());
            ps.setInt(5, plante.getCout());
            ps.setDouble(6, plante.getSoleil_par_seconde());
            ps.setString(7, plante.getEffet());
            ps.setString(8, plante.getChemin_image());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            return key.intValue();
        } else {
            throw new RuntimeException("Erreur lors de l'insertion de la plante.");
        }
    }

    public void updatePlante(Plante plante) {
        String sql = "UPDATE plante SET nom=?, point_de_vie=?, attaque_par_seconde=?, degat_attaque=?, cout=?, soleil_par_seconde=?, effet=?, chemin_image=? WHERE id_plante=?";
        jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image(),
                plante.getId_plante()
        );
    }

    public void deletePlante(int id) {
        String sql = "DELETE FROM plante WHERE id_plante=?";
        jdbcTemplate.update(sql, id);
    }
}
