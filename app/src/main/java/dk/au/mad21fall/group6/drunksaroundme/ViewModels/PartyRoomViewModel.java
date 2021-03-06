package dk.au.mad21fall.group6.drunksaroundme.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import dk.au.mad21fall.group6.drunksaroundme.Repository.Repository;

public class PartyRoomViewModel extends AndroidViewModel {
    private Repository repository;

    public PartyRoomViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }
}
