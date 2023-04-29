package com.example.mcsuts.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mcsuts.model.UserModel;

import java.util.Vector;

public class UserHelper {

    private UserDatabaseHelper userDatabaseHelper;

    private SQLiteDatabase db;

    public UserHelper(Context context){
        userDatabaseHelper = new UserDatabaseHelper(context);
    }

    public Vector<UserModel> getAllUser(){
        db = userDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM mUser", null);

        Vector<UserModel> user = new Vector<>();

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            UserModel userModel = new UserModel();
            userModel.setId(cursor.getInt(0));
            userModel.setName(cursor.getString(1));
            userModel.setEmail(cursor.getString(2));
            userModel.setPhone(cursor.getString(3));
            userModel.setPass(cursor.getString(4));
            user.add(userModel);
            cursor.moveToNext();

        }
        db.close();
        return user;
    }

    public void insertUser(String name, String email, String phone, String pass){
        db = userDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", name);
        contentValues.put("userEmail", email);
        contentValues.put("userPhone", phone);
        contentValues.put("userPass", pass);

        db.insert("UserData", null, contentValues);
        db.close();


    }

    public void deletUser(Integer id){
        db = userDatabaseHelper.getWritableDatabase();
        db.delete("UserData", "id = ?", new String[]{id+""});
        db.close();
    }

}
