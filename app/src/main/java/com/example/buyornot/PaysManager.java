package com.example.buyornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaysManager {




    private static final String TABLE_NAME = "pays";
    public static final String KEY_ID_PAYS="pay_id";
    public static final String KEY_LIBELLE_PAYS="pay_libelle";

    public static final String CREATE_TABLE_PAYS = "CREATE TABLE"+TABLE_NAME+
            " (" +
            " "+KEY_ID_PAYS+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_PAYS+" TEXT"+
            ");";
    private MySQLite maBaseSQLite;
    private SQLiteDatabase db;

    // Constructeur
    public PaysManager(Context context)
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

    public long addPays(Pays magasin) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_PAYS, magasin.getPay_id());


        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME, null, values);
    }

    public int modPays(Pays magasin) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_PAYS, magasin.getPay_id());
        String where = KEY_ID_PAYS+" = ?";
        String[] whereArgs = {magasin.getPay_id()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);         }

    public int supPays(Pays magasin) {
        // suppression d'un enregistrement
        // valeur de retour :(int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_PAYS+" = ?";
        String[] whereArgs = {magasin.getPay_id()+""};

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

    public Pays getPays(int id) {
        // Retourne l'magasin dont l'id est passé en paramètre

        Pays p = new Pays(1, "sucre");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_PAYS + "=" + id, null);

        if (c.moveToFirst()) {
            p.setPay_id(c.getInt(c.getColumnIndex(KEY_ID_PAYS)));
            p.setPay_libelle(c.getString(c.getColumnIndex(KEY_LIBELLE_PAYS)));
            c.close();
        }
        return p;
    }

    public Cursor getPays() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

}
