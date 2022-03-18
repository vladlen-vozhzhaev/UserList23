package com.example.phonebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phonebook.database.UserBaseHelper;
import com.example.phonebook.database.UserDBSchema;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> userList;
    private static Users users;
    private SQLiteDatabase database;

    private Users(Context context) {
        this.database = new UserBaseHelper(context).getWritableDatabase();
    }

    public static Users getUsers(Context context){
        if(users == null)
            users =  new Users(context);
        return users;
    }

    // Метод добавленя пользователя в коллекцию
    public void addUser(User user){
        ContentValues values= getContentValues(user);
        database.insert(UserDBSchema.UserTable.NAME, null, values);
        //this.userList.add(user);
    }
    private ContentValues getContentValues(User user){
        ContentValues values = new ContentValues();
        values.put(UserDBSchema.Cols.UUID, user.getUuid().toString());
        values.put(UserDBSchema.Cols.USERNAME, user.getName());
        values.put(UserDBSchema.Cols.USERLASTNAME, user.getLastname());
        values.put(UserDBSchema.Cols.PHONE, user.getPhone());
        return values;
    }

    private UserCursorWrapper queryUsers(){
        Cursor cursor = database.query(UserDBSchema.UserTable.NAME, null, null, null, null, null, null);
        return new UserCursorWrapper(cursor);
    }

    public ArrayList<User> getUserList(){
        this.userList = new ArrayList<>();
        UserCursorWrapper cursorWrapper = queryUsers();
        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                User user = cursorWrapper.getUser();
                userList.add(user);
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return userList;
    }

    public void deleteUser(){
        // Метод удаления записи из БД
    }
    public void updateUser(){
        // Метод редактирования записи
    }
}
