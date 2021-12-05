package dk.au.mad21fall.group6.drunksaroundme.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import dk.au.mad21fall.group6.drunksaroundme.R;
//import dk.au.mad21fall.group6.drunksaroundme.Views.Adapters.PartyRoomAdapter;

public class PartyRoomActivity extends AppCompatActivity {

    private Button btnAddDrink, btnLeaveParty, btnStartTest;

    private RecyclerView rcv;
    //private PartyRoomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_room);

        rcv = findViewById(R.id.rcvPartyList);

        rcv.setLayoutManager(new LinearLayoutManager(this));
        //adapter = new PartyRoomAdapter(this);
        //rcv.setAdapter(adapter);

    }
}