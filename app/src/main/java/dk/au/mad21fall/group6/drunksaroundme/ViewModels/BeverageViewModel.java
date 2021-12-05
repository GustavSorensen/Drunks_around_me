package dk.au.mad21fall.group6.drunksaroundme.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import dk.au.mad21fall.group6.drunksaroundme.Repository.Repository;

public class BeverageViewModel extends AndroidViewModel {
private Repository repository;

    public BeverageViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public void beerConsumed(){

    }
}
