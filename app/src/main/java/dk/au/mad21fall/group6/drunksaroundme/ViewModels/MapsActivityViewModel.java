package dk.au.mad21fall.group6.drunksaroundme.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import dk.au.mad21fall.group6.drunksaroundme.Repository.Repository;
import dk.au.mad21fall.group6.drunksaroundme.Services.GPSTracker;

public class MapsActivityViewModel extends AndroidViewModel {
    Repository rp;
    private GPSTracker gps;

    public MapsActivityViewModel(Application app){
        super(app);
        rp = Repository.getInstance(app);
    }



}
