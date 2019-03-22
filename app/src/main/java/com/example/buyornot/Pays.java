package com.example.buyornot;

public class Pays {


    private int pay_id;
    private String pay_libelle;

    //constructeur
    public Pays(int pay_id, String pay_libelle) {
        this.pay_id = pay_id;
        this.pay_libelle = pay_libelle;
    }

    //getters et setters

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public String getPay_libelle() {
        return pay_libelle;
    }

    public void setPay_libelle(String pay_libelle) {
        this.pay_libelle = pay_libelle;
    }
}
