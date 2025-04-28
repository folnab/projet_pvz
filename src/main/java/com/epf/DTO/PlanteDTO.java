package com.epf.DTO;

public class PlanteDTO {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private String effet;
    private String chemin_image;

    public int getId_plante() {
        return id_plante;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public String getEffet() {
        return effet;
    }

    public double getSoleil_par_seconde() {
        return soleil_par_seconde;
    }

    public int getCout() {
        return cout;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public double getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public String getNom() {
        return nom;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public void setAttaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setSoleil_par_seconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
