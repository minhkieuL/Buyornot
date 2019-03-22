package com.example.buyornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CertificationManager {

    private static final String TABLE_NAME = "certification";
    public static final String KEY_ID_CERTIFICATION="cat_id";
    public static final String KEY_LIBELLE_CERTIFICATION="cat_libelle";

    public static final String CREATE_TABLE_CERTIFICATION = "CREATE TABLE"+TABLE_NAME+
            " (" +
            " "+KEY_ID_CERTIFICATION+" INTEGER primary key AUTOINCREMENT," +
            " "+KEY_LIBELLE_CERTIFICATION+" TEXT"+
            ");";
    private MySQLite maBaseSQLite;
    private SQLiteDatabase db;

    // Constructeur
    public CertificationManager(Context context)
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

    public long addCertification(Certification certification) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_CERTIFICATION, certification.getCer_id());


        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME, null, values);
    }

    public int modCertification(Certification certification) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_CERTIFICATION, certification.getCer_id());
        String where = KEY_ID_CERTIFICATION+" = ?";
        String[] whereArgs = {certification.getCer_id()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);         }

    public int supCertification(Certification certification) {
        // suppression d'un enregistrement
        // valeur de retour :(int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_CERTIFICATION+" = ?";
        String[] whereArgs = {certification.getCer_id()+""};

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

    public Certification getCertification(int id) {
        // Retourne l'certification dont l'id est passé en paramètre

        Certification p = new Certification(1, "sucre");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_CERTIFICATION + "=" + id, null);

        if (c.moveToFirst()) {
            p.setCer_id(c.getInt(c.getColumnIndex(KEY_ID_CERTIFICATION)));
            p.setCer_libelle(c.getString(c.getColumnIndex(KEY_LIBELLE_CERTIFICATION)));
            c.close();
        }
        return p;
    }

    public Cursor getCertification() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }


}