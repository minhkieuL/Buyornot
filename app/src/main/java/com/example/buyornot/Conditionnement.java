package com.example.buyornot;

public class Conditionnement {

    private int con_id;
    private String con_libelle;

    //constructeur
    public Conditionnement(int con_id, String con_libelle) {
        this.con_id = con_id;
        this.con_libelle = con_libelle;
    }

    //getters et setters

    public int getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public String getCon_libelle() {
        return con_libelle;
    }

    public void setCon_libelle(String con_libelle) {
        this.con_libelle = con_libelle;
    }

}
