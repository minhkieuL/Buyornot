package com.example.buyornot;

public class Categorie {

    private int cat_id;
    private String cat_libelle;

//constructeur
    public Categorie(int cat_id, String cat_libelle) {
        this.cat_id = cat_id;
        this.cat_libelle = cat_libelle;
    }

    //getters et setters

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_libelle() {
        return cat_libelle;
    }

    public void setCat_libelle(String cat_libelle) {
        this.cat_libelle = cat_libelle;
    }

}
