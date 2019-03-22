package com.example.buyornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CategorieManager {

    private static final String TABLE_NAME = "categorie";
    public static final String KEY_ID_CATEGORIE="cat_id";
    public static final String KEY_LIBELLE_CATEGORIE="cat_libelle";

    public static final String CREATE_TABLE_CATEGORIE = "CREATE TABLE"+TABLE_NAME+
            " (" +
            " "+KEY_ID_CATEGORIE+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_CATEGORIE+" TEXT"+
            ");";
    private MySQLite maBaseSQLite;
    private SQLiteDatabase db;

    // Constructeur
    public CategorieManager(Context context)
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

    public long addCategorie(Categorie categorie) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_CATEGORIE, categorie.getCat_libelle());


        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME, null, values);
    }

    public int modCategorie(Categorie categorie) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_CATEGORIE, categorie.getCat_libelle());
        String where = KEY_ID_CATEGORIE+" = ?";
        String[] whereArgs = {categorie.getCat_id()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);         }

    public int supCategorie(Categorie categorie) {
        // suppression d'un enregistrement
        // valeur de retour :(int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_CATEGORIE+" = ?";
        String[] whereArgs = {categorie.getCat_libelle()+""};

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

    public Categorie getCategorie(int id) {
        // Retourne l'categorie dont l'id est passé en paramètre

        Categorie p = new Categorie(1, "sucre");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_CATEGORIE + "=" + id, null);

        if (c.moveToFirst()) {
            p.setCat_id(c.getInt(c.getColumnIndex(KEY_ID_CATEGORIE)));
            p.setCat_libelle(c.getString(c.getColumnIndex(KEY_LIBELLE_CATEGORIE)));
            c.close();
        }
        return p;
    }

    public Cursor getCategorie() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }


}