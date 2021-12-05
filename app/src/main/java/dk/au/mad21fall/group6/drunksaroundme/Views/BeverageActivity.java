package dk.au.mad21fall.group6.drunksaroundme.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dk.au.mad21fall.group6.drunksaroundme.R;

public class BeverageActivity extends AppCompatActivity {

    private Button btnBeer, btnDrink, btnShot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);

        setupUI();

        btnBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Kald til repo om, at man har drukket en øl
                setResult(RESULT_OK);
                finish();
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Kald til repo om, at man har drukket en drink
                setResult(RESULT_OK);
                finish();
            }
        });

        btnShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Kald til repo om, at man har drukket et shot
                setResult(RESULT_OK);
                finish();
            }
        });

    }

    private void setupUI() {
        btnBeer = findViewById(R.id.btnBeer);
        btnDrink = findViewById(R.id.btnDrink);
        btnShot = findViewById(R.id.btnShot);
    }
}