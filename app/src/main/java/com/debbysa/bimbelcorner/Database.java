package com.debbysa.bimbelcorner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;

import java.sql.Blob;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "bimbel.db";
    public static final String TABLE_NAME = "bimbel_table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "nama";
    public static final String COL_3 = "alamat";
    public static final String COL_4 = "deskripsi";
//    public static final Blob COL_5 = "image";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(id integer primary key autoincrement, nama text, alamat text, deskripsi text, image BLOB )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP Table IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String nama, String alamat, String deskripsi, byte[] image){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT into "+TABLE_NAME+" values (null, ?,?,?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, nama);
        statement.bindString(2, alamat);
        statement.bindString(3, deskripsi);
        statement.bindBlob(4, image);

        statement.executeInsert();

//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2, nama);
//        contentValues.put(COL_3, alamat);
//        contentValues.put(COL_4, deskripsi);
//
//        long result = db.insert(TABLE_NAME, null, contentValues);

        //pengecekan dari perintah insert
//        if (result == -1)
//            return false;
//        else
//            return true;
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

//    public Cursor getWordMatches(String query, String[] columns) {
//        String selection = COL_2 + " MATCH ?";
//        String[] selectionArgs = new String[] {query+"*"};
//
//        return query(selection, selectionArgs, columns);
//    }

//    private Cursor query(String selection, String[] selectionArgs, String[] columns) {
//        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
//        builder.setTables(TABLE_NAME);
//
//        Cursor cursor = builder.query(databaseOpenHelper.getReadableDatabase(),
//                columns, selection, selectionArgs, null, null, null);
//
//        if (cursor == null) {
//            return null;
//        } else if (!cursor.moveToFirst()) {
//            cursor.close();
//            return null;
//        }
//        return cursor;
//    }
}
