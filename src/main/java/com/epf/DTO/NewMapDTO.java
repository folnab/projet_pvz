package com.epf.DTO;

public class NewMapDTO {
    private int ligne;
    private int colonne;
    private String chemin_image;

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
