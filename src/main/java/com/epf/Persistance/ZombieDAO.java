package com.epf.Persistance;

import com.epf.Mappers.ZombieRowMapper;
import com.epf.Models.Zombie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ZombieDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Zombie> findAll() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    public Zombie findById(int id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new ZombieRowMapper(), id);
    }

    public int CreateZombie(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id_zombie"});
            ps.setString(1, zombie.getNom());
            ps.setInt(2, zombie.getPointDeVie());
            ps.setDouble(3, zombie.getAttaqueParSeconde());
            ps.setInt(4, zombie.getDegatAttaque());
            ps.setDouble(5, zombie.getVitesseDeDeplacement());
            ps.setString(6, zombie.getCheminImage());
            if (zombie.getIdMap() != 0) {
                ps.setInt(7, zombie.getIdMap());
            } else {
                ps.setNull(7, java.sql.Types.INTEGER);
            }
            return ps;
        }, keyHolder);

        // Récupérer l'id généré
        Number key = keyHolder.getKey();
        if (key != null) {
            return key.intValue(); // tu récupères l'id_zombie généré
        } else {
            throw new RuntimeException("Erreur lors de la création du zombie : clé générée manquante.");
        }
    }

    public void updateZombie(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPointDeVie(),
                zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(),
                zombie.getVitesseDeDeplacement(),
                zombie.getCheminImage(),
                zombie.getIdMap(),
                zombie.getIdZombie()
        );
    }

    public void deleteZombie(int id) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }
}

