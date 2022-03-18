package com.example.phonebook.database;

import static com.example.phonebook.database.UserDBSchema.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "userBase_23.db";

    public UserBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ UserTable.NAME+"(" +
                "_id integer primary key autoincrement, " +
                Cols.UUID+", " +
                Cols.USERNAME+"," +
                Cols.USERLASTNAME+"," +
                Cols.PHONE+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Вызывается тогда, когда мы меняем структуру таблицы БД
    }
}
