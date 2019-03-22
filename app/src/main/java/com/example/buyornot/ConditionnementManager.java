package com.example.buyornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConditionnementManager {

    private static final String TABLE_NAME = "certification";
    public static final String KEY_ID_CONDITIONNEMENT="cat_id";
    public static final String KEY_LIBELLE_CONDITIONNEMENT="cat_libelle";

    public static final String CREATE_TABLE_CONDITIONNEMENT = "CREATE TABLE"+TABLE_NAME+
            " (" +
            " "+KEY_ID_CONDITIONNEMENT+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_CONDITIONNEMENT+" TEXT"+
            ");";
    private MySQLite maBaseSQLite;
    private SQLiteDatabase db;

    // Constructeur
    public ConditionnementManager(Context context)
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

    public long addConditionnement(Conditionnement certification) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_CONDITIONNEMENT, certification.getCon_id());


        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME, null, values);
    }

    public int modConditionnement(Conditionnement certification) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_CONDITIONNEMENT, certification.getCon_id());
        String where = KEY_ID_CONDITIONNEMENT+" = ?";
        String[] whereArgs = {certification.getCon_id()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);         }

    public int supConditionnement(Conditionnement certification) {
        // suppression d'un enregistrement
        // valeur de retour :(int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_CONDITIONNEMENT+" = ?";
        String[] whereArgs = {certification.getCon_id()+""};

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

    public Conditionnement getContification(int id) {
        // Retourne l'certification dont l'id est passé en paramètre

        Conditionnement p = new Conditionnement(1, "sucre");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_CONDITIONNEMENT + "=" + id, null);

        if (c.moveToFirst()) {
            p.setCon_id(c.getInt(c.getColumnIndex(KEY_ID_CONDITIONNEMENT)));
            p.setCon_libelle(c.getString(c.getColumnIndex(KEY_LIBELLE_CONDITIONNEMENT)));
            c.close();
        }
        return p;
    }

    public Cursor getContification() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }


}