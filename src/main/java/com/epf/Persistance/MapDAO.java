package com.epf.Persistance;

import com.epf.Models.Map;
import com.epf.Mappers.MapRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class MapDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map> findAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    public Map findById(int id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new MapRowMapper(), id);
    }

    public int createMap(Map map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id_map"});
            ps.setInt(1, map.getLigne());
            ps.setInt(2, map.getColonne());
            ps.setString(3, map.getCheminImage());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            return key.intValue();
        } else {
            throw new RuntimeException("Erreur lors de l'insertion de la map.");
        }
    }

    public void updateMap(Map map) {
        String sql = "UPDATE map SET ligne=?, colonne=?, chemin_image=? WHERE id_map=?";
        jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getCheminImage(),
                map.getIdMap()
        );
    }

    public void deleteMap(int id) {
        String sql = "DELETE FROM map WHERE id_map=?";
        jdbcTemplate.update(sql, id);
    }
}
