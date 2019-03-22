package com.example.buyornot;

public class Produit {

    private int pro_id;
    private String pro_libelle;
    private int pro_quantite;
    private int pro_marque;
    private int pro_categ;
    private int pro_magasin;
    private int pro_paysvente;
    private String pro_listeingredient;
    private int pro_conditionnement;
    private int pro_certification;


    private int pro_additif;
    private int pro_origineingredient;
    private int pro_lieuxfabrication;
    private String pro_codeemballage;
    private String pro_lienpageweb;


    //constructeur
    public Produit(int pro_id, String pro_libelle, int pro_quantite, int pro_additif, int pro_marque, int pro_categ, int pro_magasin, int pro_paysvente, String pro_listeingredient, int pro_conditionnement, int pro_certification, int pro_origineingredient, int pro_lieuxfabrication, String pro_codeemballage, String pro_lienpageweb) {
        this.pro_id = pro_id;
        this.pro_libelle = pro_libelle;
        this.pro_quantite = pro_quantite;
        this.pro_marque = pro_marque;
        this.pro_categ = pro_categ;
        this.pro_magasin = pro_magasin;
        this.pro_paysvente = pro_paysvente;
        this.pro_listeingredient = pro_listeingredient;
        this.pro_conditionnement = pro_conditionnement;
        this.pro_certification = pro_certification;
        this.pro_origineingredient = pro_origineingredient;
        this.pro_lieuxfabrication = pro_lieuxfabrication;
        this.pro_codeemballage = pro_codeemballage;
        this.pro_lienpageweb = pro_lienpageweb;
        this.pro_additif = pro_additif;
    }

    //getters et setters

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_libelle() {
        return pro_libelle;
    }

    public void setPro_libelle(String pro_libelle) {
        this.pro_libelle = pro_libelle;
    }

    public int getPro_quantite() {
        return pro_quantite;
    }

    public void setPro_quantite(int pro_quantite) {
        this.pro_quantite = pro_quantite;
    }

    public int getPro_marque() {
        return pro_marque;
    }

    public void setPro_marque(int pro_marque) {
        this.pro_marque = pro_marque;
    }

    public int getPro_categ() {
        return pro_categ;
    }

    public void setPro_categ(int pro_categ) {
        this.pro_categ = pro_categ;
    }

    public int getPro_magasin() {
        return pro_magasin;
    }

    public void setPro_magasin(int pro_magasin) {
        this.pro_magasin = pro_magasin;
    }

    public int getPro_paysvente() {
        return pro_paysvente;
    }

    public void setPro_paysvente(int pro_paysvente) {
        this.pro_paysvente = pro_paysvente;
    }

    public String getPro_listeingredient() {
        return pro_listeingredient;
    }

    public void setPro_listeingredient(String pro_listeingredient) {
        this.pro_listeingredient = pro_listeingredient;
    }

    public int getPro_conditionnement() {
        return pro_conditionnement;
    }

    public void setPro_conditionnement(int pro_conditionnement) {
        this.pro_conditionnement = pro_conditionnement;
    }

    public int getPro_certification() {
        return pro_certification;
    }

    public void setPro_certification(int pro_certification) {
        this.pro_certification = pro_certification;
    }

    public int getPro_origineingredient() {
        return pro_origineingredient;
    }

    public void setPro_origineingredient(int pro_origineingredient) {
        this.pro_origineingredient = pro_origineingredient;
    }

    public int getPro_lieuxfabrication() {
        return pro_lieuxfabrication;
    }

    public void setPro_lieuxfabrication(int pro_lieuxfabrication) {
        this.pro_lieuxfabrication = pro_lieuxfabrication;
    }

    public String getPro_codeemballage() {
        return pro_codeemballage;
    }

    public void setPro_codeemballage(String pro_codeemballage) {
        this.pro_codeemballage = pro_codeemballage;
    }

    public String getPro_lienpageweb() {
        return pro_lienpageweb;
    }

    public void setPro_lienpageweb(String pro_lienpageweb) {
        this.pro_lienpageweb = pro_lienpageweb;
    }

    public int getPro_additif() {
        return pro_additif;
    }

    public void setPro_additif(int pro_additif) {
        this.pro_additif = pro_additif;
    }

}
