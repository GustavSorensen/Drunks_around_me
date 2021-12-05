package dk.au.mad21fall.group6.drunksaroundme.Views;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dk.au.mad21fall.group6.drunksaroundme.R;

public class LoginActivity extends AppCompatActivity {

    private TextView txtAppName, txtEmail, txtPassword;
    private EditText etxtEmail, etxtPassword;
    private Button btnLogin, btnSignup;

    FirebaseAuth auth;

    //Inspiration for login was found here:
    //https://www.youtube.com/watch?v=iSsa9OlQJms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();

        if(auth==null){
            auth = FirebaseAuth.getInstance();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = auth.getCurrentUser();
        if (user != null){
            goToMap();
        }
    }

    private void signUp() {
        Intent i = new Intent(this, SignupActivity.class);
        launcher.launch(i);
    }

    private void setupUI() {
        txtAppName = findViewById(R.id.txtAppname);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        etxtEmail = findViewById(R.id.etxtEmail);
        etxtPassword = findViewById(R.id.etxtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
    }

    private void login() {
        String email = etxtEmail.getText().toString();
        String password = etxtPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            etxtEmail.setError("Need email");
            etxtEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etxtPassword.setError("Need password");
            etxtPassword.requestFocus();
        }else{
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        goToMap();
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    private void goToMap() {
        Intent i = new Intent(this, MapsActivity.class);

        Log.d("Gustav", "goToMap: "+ auth.getCurrentUser().getEmail());
        launcher.launch(i);
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