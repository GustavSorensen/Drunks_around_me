package dk.au.mad21fall.group6.drunksaroundme.Repository;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dk.au.mad21fall.group6.drunksaroundme.models.Location;
import dk.au.mad21fall.group6.drunksaroundme.models.Person;

@Database(entities = {Person.class, /*Location.class*/}, version = 1)
public abstract class DrinkingDB extends RoomDatabase {
    public abstract PersonDAO PersonDao();
    private static DrinkingDB instance;
    public static synchronized DrinkingDB getDB(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DrinkingDB.class,"DrinkingDB")
                    .fallbackToDestructiveMigration()
                    .build();
            Log.d("BUILD_DB_TAG","BUILT");
        }
        return instance;
    }
}
