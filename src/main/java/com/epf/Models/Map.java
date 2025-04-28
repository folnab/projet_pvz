package com.epf.Models;

public class Map {
    private int idMap;
    private int ligne;
    private int colonne;
    private String cheminImage;

    // Constructeur
    public Map(int idMap, int ligne, int colonne, String cheminImage) {
        this.idMap = idMap;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    public Map() {
    }

    public int getIdMap() {
        return idMap;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
}
