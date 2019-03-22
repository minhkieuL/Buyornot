package com.example.buyornot;

public class Marque {

    private int mar_id;
    private String mar_libelle;

    //constructeur
    public Marque(int mar_id, String mar_libelle) {
        this.mar_id = mar_id;
        this.mar_libelle = mar_libelle;
    }

    //getters et setters

    public int getMar_id() {
        return mar_id;
    }

    public void setMar_id(int mar_id) {
        this.mar_id = mar_id;
    }

    public String getMar_libelle() {
        return mar_libelle;
    }

    public void setMar_libelle(String mar_libelle) {
        this.mar_libelle = mar_libelle;
    }

}
