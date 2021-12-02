package dk.au.mad21fall.group6.drunksaroundme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView txtvHelloWorld;
    Button btnLogout;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtvHelloWorld = findViewById(R.id.txtvHello);
        txtvHelloWorld.setText(auth.getInstance().getCurrentUser().getDisplayName());

        btnLogout = findViewById(R.id.btnMainLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.getInstance().signOut();
                finish();
            }
        });
    }
}