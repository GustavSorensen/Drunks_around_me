package dk.au.mad21fall.group6.drunksaroundme.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Telephony;
import android.widget.Button;

import java.util.ArrayList;

import dk.au.mad21fall.group6.drunksaroundme.R;
import dk.au.mad21fall.group6.drunksaroundme.Views.Adapters.PartyRoomAdapter;
import dk.au.mad21fall.group6.drunksaroundme.models.Person;

public class PartyRoomActivity extends AppCompatActivity implements PartyRoomAdapter.IPersonItemClickedListener {

    private Button btnAddDrink, btnLeaveParty, btnStartTest;

    private RecyclerView rcv;
    private PartyRoomAdapter adapter;

    //Skal få personer fra ViewModel
    private ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_room);

        rcv = findViewById(R.id.rcvPartyList);

        rcv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PartyRoomAdapter(this);
        rcv.setAdapter(adapter);

        //Skal være en observe på ViewModel
        createData();
        adapter.updatePersonList(persons);

    }

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
}