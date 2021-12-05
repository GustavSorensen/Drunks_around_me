package dk.au.mad21fall.group6.drunksaroundme.Repository;

import android.location.Location;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import dk.au.mad21fall.group6.drunksaroundme.models.Person;

@Dao
public interface PersonDAO {

    @Query("SELECT * FROM person")
    LiveData<List<Person>> getPerson();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPerson(Person p);

    @Update
    void updatePerson(Person p);

    @Delete
    void delete(Person p);
/*
    @Query("SELECT * FROM location")
    LiveData<List<Location>> getLocation();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addLocation(Location loc);*/
}
