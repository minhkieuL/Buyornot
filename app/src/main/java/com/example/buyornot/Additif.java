package com.example.buyornot;

public class Additif {
    private int add_id;
    private String add_libelle;

    //constructeur
    public Additif(int add_id, String add_libelle) {
        this.add_id = add_id;
        this.add_libelle = add_libelle;
    }

    //getters et settersq

    public int getCat_id() {
        return add_id;
    }

    public void setAdd_id(int add_id) {
        this.add_id = add_id;
    }

    public String getCat_libelle() {
        return add_libelle;
    }

    public void setAdd_libelle(String add_libelle) {
        this.add_libelle = add_libelle;
    }

}
