package com.example.mcsuts.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mcsuts.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;


    public UserDatabaseHelper(@Nullable Context context) {
        super(context, "UserData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE mUser(" +
                "userID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userName TEXT NOT NULL," +
                "userEmail TEXT NOT NULL," +
                "userPhone TEXT NOT NULL," +
                "userPass TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mUser");

        onCreate(db);
    }


    public List<UserModel> getAllUser(){
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM mUser", null);

        List<UserModel> user = new ArrayList<>();

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
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", name);
        contentValues.put("userEmail", email);
        contentValues.put("userPhone", phone);
        contentValues.put("userPass", pass);

        db.insert("mUser", null, contentValues);
        db.close();


    }

    public void deletUser(Integer id){
        db = this.getWritableDatabase();
        db.delete("mUser", "id = ?", new String[]{id+""});
        db.close();
    }
}
