package com.example.mcsuts.adapter;

import android.app.Activity;
import android.content.Context;

import com.example.mcsuts.helper.UserHelper;
import com.example.mcsuts.model.UserModel;

import java.util.Vector;

public class DatabaseAdapter {
    private  static DatabaseAdapter database;
    private UserHelper userHelper;


    private DatabaseAdapter(Context context){
        userHelper = new UserHelper(context);
    }

//    cek databasenya
    public static DatabaseAdapter getInstance(Context context){
//        databasenya kosong nda?
        if(database == null){
//            kalo kosong di synchronized dulu biar engga tabrakan
            synchronized (DatabaseAdapter.class){
//                di cek lagi, kosong nda?
                if(database == null){
//                    kalo kosong buat databaseadapter baru
                    database = new DatabaseAdapter(context);
                }
            }
        }
//        kalo ga kosong return databasenya
        return database;
    }

    public Vector<UserModel> getUserData(){
        return userHelper.getAllUser();
    }

    public void insertUserData(String name, String email, String phone, String pass){
        userHelper.insertUser(name, email, phone, pass);
    }


}
