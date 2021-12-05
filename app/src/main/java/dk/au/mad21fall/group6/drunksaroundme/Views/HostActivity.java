package dk.au.mad21fall.group6.drunksaroundme.Views;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dk.au.mad21fall.group6.drunksaroundme.R;

public class HostActivity extends AppCompatActivity {

    private EditText etxtPartyName, etxtPartyDescription;
    private Button btnCancel, btnCreateParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        setupUI();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCreateParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HostActivity.this, PartyRoomActivity.class);
                launcher.launch(i);
            }
        });
    }

    private void setupUI() {
        etxtPartyName = findViewById(R.id.etxtHostPartyName);
        etxtPartyDescription = findViewById(R.id.etxtHostPartyDescription);
        btnCancel = findViewById(R.id.btnHostCancel);
        btnCreateParty = findViewById(R.id.btnHostParty);

    }

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