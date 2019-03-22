package com.example.buyornot;

public class NutriNova {

    private int nut_id;
    private String nut_libelle;

    //constructeur
    public NutriNova(int nut_id, String nut_libelle) {
        this.nut_id = nut_id;
        this.nut_libelle = nut_libelle;
    }

    //getters et setters

    public int getNut_id() {
        return nut_id;
    }

    public void setNut_id(int nut_id) {
        this.nut_id = nut_id;
    }

    public String getNut_libelle() {
        return nut_libelle;
    }

    public void setNut_libelle(String nut_libelle) {
        this.nut_libelle = nut_libelle;
    }

}
