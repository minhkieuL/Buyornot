package com.example.buyornot;

public class Magasin {

    private int mag_id;
    private String mag_libelle;

    //constructeur
    public Magasin(int mag_id, String mag_libelle) {
        this.mag_id = mag_id;
        this.mag_libelle = mag_libelle;
    }

    //getters et setters

    public int getMag_id() {
        return mag_id;
    }

    public void setMag_id(int mag_id) {
        this.mag_id = mag_id;
    }

    public String getMag_libelle() {
        return mag_libelle;
    }

    public void setMag_libelle(String mag_libelle) {
        this.mag_libelle = mag_libelle;
    }
}
