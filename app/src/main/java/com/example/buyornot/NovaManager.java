package com.example.buyornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaManager {


    private static final String TABLE_NAME = "nova";
    public static final String KEY_ID_NOVA="nov_id";
    public static final String KEY_LIBELLE_NOVA="nov_libelle";

    public static final String CREATE_TABLE_NOVA = "CREATE TABLE"+TABLE_NAME+
            " (" +
            " "+KEY_ID_NOVA+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_NOVA+" TEXT"+
            ");";
    private MySQLite maBaseSQLite;
    private SQLiteDatabase db;

    // Constructeur
    public NovaManager(Context context)
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

    public long addNova(Nova magasin) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_NOVA, magasin.getNov_id());


        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME, null, values);
    }

    public int modNova(Nova magasin) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_NOVA, magasin.getNov_id());
        String where = KEY_ID_NOVA+" = ?";
        String[] whereArgs = {magasin.getNov_id()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);         }

    public int supNova(Nova magasin) {
        // suppression d'un enregistrement
        // valeur de retour :(int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_NOVA+" = ?";
        String[] whereArgs = {magasin.getNov_id()+""};

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

    public Nova getNova(int id) {
        // Retourne l'magasin dont l'id est passé en paramètre

        Nova p = new Nova(1, "sucre");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_NOVA + "=" + id, null);

        if (c.moveToFirst()) {
            p.setNov_id(c.getInt(c.getColumnIndex(KEY_ID_NOVA)));
            p.setNov_libelle(c.getString(c.getColumnIndex(KEY_LIBELLE_NOVA)));
            c.close();
        }
        return p;
    }

    public Cursor getNova() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

}
