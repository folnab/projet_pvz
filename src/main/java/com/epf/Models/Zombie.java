package com.epf.Models;

public class Zombie {
    private int idZombie;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeDeplacement;
    private String cheminImage;
    private int idMap;

    // Constructeur
    public Zombie(int idZombie, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, double vitesseDeDeplacement, String cheminImage, int idMap) {
        this.idZombie = idZombie;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.vitesseDeDeplacement = vitesseDeDeplacement;
        this.cheminImage = cheminImage;
        this.idMap = idMap;
    }

    // Getters et Setters
    public int getIdZombie() { return idZombie; }
    public void setIdZombie(int idZombie) { this.idZombie = idZombie; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPointDeVie() { return pointDeVie; }
    public void setPointDeVie(int pointDeVie) { this.pointDeVie = pointDeVie; }

    public double getAttaqueParSeconde() { return attaqueParSeconde; }
    public void setAttaqueParSeconde(double attaqueParSeconde) { this.attaqueParSeconde = attaqueParSeconde; }

    public int getDegatAttaque() { return degatAttaque; }
    public void setDegatAttaque(int degatAttaque) { this.degatAttaque = degatAttaque; }

    public double getVitesseDeDeplacement() { return vitesseDeDeplacement; }
    public void setVitesseDeDeplacement(double vitesseDeDeplacement) { this.vitesseDeDeplacement = vitesseDeDeplacement; }

    public String getCheminImage() { return cheminImage; }
    public void setCheminImage(String cheminImage) { this.cheminImage = cheminImage; }

    public int getIdMap() { return idMap; }
    public void setIdMap(int idMap) { this.idMap = idMap; }
}
