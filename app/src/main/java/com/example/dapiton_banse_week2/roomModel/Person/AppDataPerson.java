package com.example.dapiton_banse_week2.roomModel.Person;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserAccounts.class, Possesions.class}, version = 2)
public abstract class AppDataPerson extends RoomDatabase {
    private static AppDataPerson instance;
    public abstract DaoUserAccounts daoAccounts();

    public static AppDataPerson getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataPerson.class, "UserAccounts")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
