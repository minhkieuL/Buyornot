package com.example.buyornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MagasinManager {

    private static final String TABLE_NAME = "magasin";
    public static final String KEY_ID_MAGASIN="cat_id";
    public static final String KEY_LIBELLE_MAGASIN="cat_libelle";

    public static final String CREATE_TABLE_MAGASIN = "CREATE TABLE"+TABLE_NAME+
            " (" +
            " "+KEY_ID_MAGASIN+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_MAGASIN+" TEXT"+
            ");";
    private MySQLite maBaseSQLite;
    private SQLiteDatabase db;

    // Constructeur
    public MagasinManager(Context context)
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

    public long addMagasin(Magasin magasin) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_MAGASIN, magasin.getMag_id());


        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME, null, values);
    }

    public int modMagasin(Magasin magasin) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_MAGASIN, magasin.getMag_id());
        String where = KEY_ID_MAGASIN+" = ?";
        String[] whereArgs = {magasin.getMag_id()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);         }

    public int supMagasin(Magasin magasin) {
        // suppression d'un enregistrement
        // valeur de retour :(int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_MAGASIN+" = ?";
        String[] whereArgs = {magasin.getMag_id()+""};

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

    public Magasin getMagasin(int id) {
        // Retourne l'magasin dont l'id est passé en paramètre

        Magasin p = new Magasin(1, "sucre");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_MAGASIN + "=" + id, null);

        if (c.moveToFirst()) {
            p.setMag_id(c.getInt(c.getColumnIndex(KEY_ID_MAGASIN)));
            p.setMag_libelle(c.getString(c.getColumnIndex(KEY_LIBELLE_MAGASIN)));
            c.close();
        }
        return p;
    }

    public Cursor getMagasin() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }


}
