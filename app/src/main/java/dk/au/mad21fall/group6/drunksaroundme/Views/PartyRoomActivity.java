package dk.au.mad21fall.group6.drunksaroundme.Views;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import dk.au.mad21fall.group6.drunksaroundme.R;
import dk.au.mad21fall.group6.drunksaroundme.Views.Adapters.PartyRoomAdapter;
import dk.au.mad21fall.group6.drunksaroundme.models.Person;

public class PartyRoomActivity extends AppCompatActivity implements PartyRoomAdapter.IPersonItemClickedListener {

    private Button btnAddDrink, btnLeaveParty, btnStartTest;

    private RecyclerView rcv;
    private PartyRoomAdapter adapter;

    //TODO: Skal få personer fra ViewModel
    private ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_room);

        setupUI();

        rcv = findViewById(R.id.rcvPartyList);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PartyRoomAdapter(this);
        rcv.setAdapter(adapter);

        //TODO: Skal være en observe på ViewModel
        createData();
        adapter.updatePersonList(persons);

        btnLeaveParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Lav kald til repo, hvor man forlader party
                finish();
            }
        });

        btnAddDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PartyRoomActivity.this, BeverageActivity.class);
                launcher.launch(i);
            }
        });

    }

    private void setupUI() {
        btnAddDrink = findViewById(R.id.btnPartyAddDrink);
        btnLeaveParty = findViewById(R.id.btnPartyLeaveRoom);
    }

    //Dummy data created så RCV ikke crasher uden ViewModels
    private void createData(){
        persons = new ArrayList<Person>();
        persons.add(new Person("Ermin","Male", 69));
        persons.add(new Person("Gustav","Male", 73));
        persons.add(new Person("Ermin","Male", 69));
        persons.add(new Person("Gustav","Male", 73));
        persons.add(new Person("Ermin","Male", 69));
        persons.add(new Person("Gustav","Male", 73));
        persons.add(new Person("Ermin","Male", 69));
        persons.add(new Person("Gustav","Male", 73));
        persons.add(new Person("Ermin","Male", 69));
        persons.add(new Person("Gustav","Male", 73));
        persons.add(new Person("Ermin","Male", 69));
        persons.add(new Person("Gustav","Male", 73));
        persons.add(new Person("Ermin","Male", 69));
        persons.add(new Person("Gustav","Male", 73));
    }

    @Override
    public void onPersonClicked(int index) {

    }

    //Activity launcer. Taken from what was posted in Discord and changed a little
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),   //default contract
            new ActivityResultCallback<ActivityResult>() {          //our callback
                @Override
                public void onActivityResult(ActivityResult result) {   //result contains result code and data
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //Intent data = result.getData();

                    }
                }
            });
}