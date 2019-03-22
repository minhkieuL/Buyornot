package com.example.buyornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProduitManager {

    private static final String TABLE_NAME = "produit";
    public static final String KEY_ID_PRODUIT="pro_id";
    public static final String KEY_LIBELLE_PRODUIT="pro_libelle";
    public static final String KEY_QUANTITE_PRODUIT="pro_quantite";
    public static final String KEY_MARQUE_PRODUIT="pro_marque";
    public static final String KEY_CATEG_PRODUIT="pro_categ";
    public static final String KEY_MAGASIN_PRODUIT="pro_magasin";
    public static final String KEY_PAYSVENTE_PRODUIT="pro_paysvente";
    public static final String KEY_LISTEINGREDIENT_PRODUIT="pro_listeingredient";
    public static final String KEY_CONDITIONNEMENT_PRODUIT="pro_conditionnement";
    public static final String KEY_CERTIFICATION_PRODUIT="pro_certification";
    public static final String KEY_ORIGINEINGREDIENT_PRODUIT="pro_origineingredient";
    public static final String KEY_CODEEMBALLAGE_PRODUIT="pro_codeemballage";
    public static final String KEY_LIEUXFABRICATION_PRODUIT="pro_lieuxfabrication";
    public static final String KEY_LIENPAGEWEB_PRODUIT="pro_lienpageweb";
    public static final String KEY_NOVA_PRODUIT="pro_nova";
    public static final String KEY_NUTRINOVA_PRODUIT="pro_nutriNova";
    public static final String KEY_ADDITIF_PRODUIT="pro_additif";

    public static final String CREATE_TABLE_PRODUIT = "CREATE TABLE"+TABLE_NAME+
            " (" +
            " "+KEY_ID_PRODUIT+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_PRODUIT+" TEXT"+
            ");";
    private MySQLite maBaseSQLite;
    private SQLiteDatabase db;

    // Constructeur
    public ProduitManager(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);
    }

    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();

    }

    public long addProduit(Produit produit) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_PRODUIT, produit.getPro_id());
        values.put(KEY_QUANTITE_PRODUIT, produit.getPro_libelle());
        values.put(KEY_MARQUE_PRODUIT, produit.getPro_marque());
        values.put(KEY_CATEG_PRODUIT, produit.getPro_categ());
        values.put(KEY_MAGASIN_PRODUIT, produit.getPro_magasin());
        values.put(KEY_PAYSVENTE_PRODUIT, produit.getPro_paysvente());
        values.put(KEY_LISTEINGREDIENT_PRODUIT, produit.getPro_listeingredient());
        values.put(KEY_CONDITIONNEMENT_PRODUIT, produit.getPro_conditionnement());
        values.put(KEY_CERTIFICATION_PRODUIT, produit.getPro_certification());
        values.put(KEY_ORIGINEINGREDIENT_PRODUIT, produit.getPro_origineingredient());
        values.put(KEY_CODEEMBALLAGE_PRODUIT, produit.getPro_codeemballage());
        values.put(KEY_LIEUXFABRICATION_PRODUIT, produit.getPro_lieuxfabrication());
        values.put(KEY_LIENPAGEWEB_PRODUIT, produit.getPro_lienpageweb());
        values.put(KEY_ADDITIF_PRODUIT, produit.getPro_additif());
        values.put(KEY_NOVA_PRODUIT, produit.getPro_nova());
        values.put(KEY_NUTRINOVA_PRODUIT, produit.getPro_nutriNova());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME, null, values);
    }

    public int modProduit(Produit produit) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_PRODUIT, produit.getPro_id());
        values.put(KEY_QUANTITE_PRODUIT, produit.getPro_libelle());
        values.put(KEY_MARQUE_PRODUIT, produit.getPro_marque());
        values.put(KEY_CATEG_PRODUIT, produit.getPro_categ());
        values.put(KEY_MAGASIN_PRODUIT, produit.getPro_magasin());
        values.put(KEY_PAYSVENTE_PRODUIT, produit.getPro_paysvente());
        values.put(KEY_LISTEINGREDIENT_PRODUIT, produit.getPro_listeingredient());
        values.put(KEY_CONDITIONNEMENT_PRODUIT, produit.getPro_conditionnement());
        values.put(KEY_CERTIFICATION_PRODUIT, produit.getPro_certification());
        values.put(KEY_ORIGINEINGREDIENT_PRODUIT, produit.getPro_origineingredient());
        values.put(KEY_CODEEMBALLAGE_PRODUIT, produit.getPro_codeemballage());
        values.put(KEY_LIEUXFABRICATION_PRODUIT, produit.getPro_lieuxfabrication());
        values.put(KEY_LIENPAGEWEB_PRODUIT, produit.getPro_lienpageweb());
        values.put(KEY_ADDITIF_PRODUIT, produit.getPro_additif());
        values.put(KEY_NOVA_PRODUIT, produit.getPro_nova());
        values.put(KEY_NUTRINOVA_PRODUIT, produit.getPro_nutriNova());

        String where = KEY_ID_PRODUIT+" = ?";
        String[] whereArgs = {produit.getPro_id()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);         }

    public int supAnimal(Produit produit) {
        // suppression d'un enregistrement
        // valeur de retour :(int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_PRODUIT+" = ?";
        String[] whereArgs = {produit.getPro_id()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public String convertStringToDate(Date indate)
    {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");

        try{
            dateString = sdfr.format( indate);

        }catch(Exception ex){
            System.out.println(ex);
        }
        return dateString;
    }

    public Produit getProduit(int id) {
        // Retourne l'produit dont l'id est passé en paramètre

        Produit p = new Produit(1, "sucre", 40,0, 1,1, 1, 1, 1, 1, "", 1, 1, 1, 1, "", "");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_PRODUIT + "=" + id, null);

        if (c.moveToFirst()) {
            p.setPro_id(c.getInt(c.getColumnIndex(KEY_ID_PRODUIT)));
            p.setPro_libelle(c.getString(c.getColumnIndex(KEY_LIBELLE_PRODUIT)));
            p.setPro_quantite(c.getInt(c.getColumnIndex(KEY_QUANTITE_PRODUIT)));
            p.setPro_marque(Integer.parseInt(c.getString(c.getColumnIndex(KEY_MARQUE_PRODUIT))));
            p.setPro_categ(c.getInt((c.getColumnIndex(KEY_CATEG_PRODUIT))));
            p.setPro_magasin(c.getInt(c.getColumnIndex(KEY_MAGASIN_PRODUIT)));
            p.setPro_paysvente(c.getInt(c.getColumnIndex(KEY_PAYSVENTE_PRODUIT)));
            p.setPro_listeingredient(c.getString(c.getColumnIndex(KEY_LISTEINGREDIENT_PRODUIT)));
            p.setPro_conditionnement(c.getInt(c.getColumnIndex(KEY_CONDITIONNEMENT_PRODUIT)));
            p.setPro_certification(c.getInt(c.getColumnIndex(KEY_CERTIFICATION_PRODUIT)));
            p.setPro_origineingredient(c.getInt(c.getColumnIndex(KEY_ORIGINEINGREDIENT_PRODUIT)));
            p.setPro_lieuxfabrication(c.getInt(c.getColumnIndex(KEY_LIEUXFABRICATION_PRODUIT)));
            p.setPro_codeemballage(c.getString(c.getColumnIndex(KEY_CODEEMBALLAGE_PRODUIT)));
            p.setPro_lienpageweb(c.getString(c.getColumnIndex(KEY_LIENPAGEWEB_PRODUIT)));
            p.setPro_nutriNova(c.getInt(c.getColumnIndex(KEY_NUTRINOVA_PRODUIT)));
            p.setPro_nova(c.getInt(c.getColumnIndex(KEY_NOVA_PRODUIT)));
            p.setPro_additif(c.getInt(c.getColumnIndex(KEY_ADDITIF_PRODUIT)));
            c.close();
        }
        return p;
    }

    public Cursor getProduit() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }


}
