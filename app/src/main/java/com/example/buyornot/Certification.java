package com.example.buyornot;

public class Certification {

    private int cer_id;
    private String cer_libelle;

    //constructeur
    public Certification(int cer_id, String cer_libelle) {
        this.cer_id = cer_id;
        this.cer_libelle = cer_libelle;
    }

    //getters et setters

    public int getCer_id() {
        return cer_id;
    }

    public void setCer_id(int cer_id) {
        this.cer_id = cer_id;
    }

    public String getCer_libelle() {
        return cer_libelle;
    }

    public void setCer_libelle(String cer_libelle) {
        this.cer_libelle = cer_libelle;
    }

}
