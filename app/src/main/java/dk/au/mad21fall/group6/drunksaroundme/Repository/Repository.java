package dk.au.mad21fall.group6.drunksaroundme.Repository;

import android.app.Application;

import com.android.volley.RequestQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dk.au.mad21fall.group6.drunksaroundme.R;
import dk.au.mad21fall.group6.drunksaroundme.models.Location;

public class Repository {
    RequestQueue queue;
    private DrinkingDB db;
    private ExecutorService executor;
    public static Repository single_instance = null;
    private Application app;
    private Location location;

    private Repository(Application application){
        app = application;
        db = DrinkingDB.getDB(app);
        executor = Executors.newSingleThreadExecutor();
        single_instance = this;
    }

    public static Repository getInstance(Application app){
        if(single_instance == null){
            single_instance = new Repository(app);
        }
        return single_instance;
    }


}
