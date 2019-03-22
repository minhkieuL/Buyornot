package com.example.buyornot;

public class Nova {

    private int nov_id;
    private String nov_libelle;

    //constructeur
    public Nova(int nov_id, String nov_libelle) {
        this.nov_id = nov_id;
        this.nov_libelle = nov_libelle;
    }

    //getters et setters

    public int getNov_id() {
        return nov_id;
    }

    public void setNov_id(int nov_id) {
        this.nov_id = nov_id;
    }

    public String getNov_libelle() {
        return nov_libelle;
    }

    public void setNov_libelle(String nov_libelle) {
        this.nov_libelle = nov_libelle;
    }

}
