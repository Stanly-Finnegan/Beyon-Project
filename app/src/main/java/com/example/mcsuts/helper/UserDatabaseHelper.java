package com.example.mcsuts.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabaseHelper extends SQLiteOpenHelper {
    public UserDatabaseHelper(@Nullable Context context) {
        super(context.getApplicationContext(), "UserData", null, 1);
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
    }
}
