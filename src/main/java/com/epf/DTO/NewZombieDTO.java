package com.epf.DTO;

public class NewZombieDTO {
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private double vitesse_de_deplacement;
    private String chemin_image;
    private Integer id_map; // peut être null

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPoint_de_vie() { return point_de_vie; }
    public void setPoint_de_vie(int point_de_vie) { this.point_de_vie = point_de_vie; }

    public double getAttaque_par_seconde() { return attaque_par_seconde; }
    public void setAttaque_par_seconde(double attaque_par_seconde) { this.attaque_par_seconde = attaque_par_seconde; }

    public int getDegat_attaque() { return degat_attaque; }
    public void setDegat_attaque(int degat_attaque) { this.degat_attaque = degat_attaque; }

    public double getVitesse_de_deplacement() { return vitesse_de_deplacement; }
    public void setVitesse_de_deplacement(double vitesse_de_deplacement) { this.vitesse_de_deplacement = vitesse_de_deplacement; }

    public String getChemin_image() { return chemin_image; }
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }

    public Integer getId_map() { return id_map; }
    public void setId_map(Integer id_map) { this.id_map = id_map; }
}
