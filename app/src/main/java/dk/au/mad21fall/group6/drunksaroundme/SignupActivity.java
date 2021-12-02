package dk.au.mad21fall.group6.drunksaroundme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class SignupActivity extends AppCompatActivity {

    EditText etxtEmail, etxtPassword, etxtRepeatPassword;
    Button btnBack, btnCreateUser;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setupUI();

        if(auth==null){
            auth = FirebaseAuth.getInstance();
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void setupUI() {
        etxtEmail = findViewById(R.id.etxtSignupEmail);
        etxtPassword = findViewById(R.id.etxtSignupPassword);
        etxtRepeatPassword = findViewById(R.id.etxtSignupRepeatPassword);
        btnBack = findViewById(R.id.btnSignupBack);
        btnCreateUser = findViewById(R.id.btnSignupCreateUser);
    }

    private void createUser() {
        String email = etxtEmail.getText().toString();
        String password = etxtPassword.getText().toString();
        //String repeatPassword = etxtRepeatPassword.getText().toString();
        String fName = "Gustav";
        String lName = "Sorensen";
        String wName = fName+lName;

        if (TextUtils.isEmpty(email)){
            etxtEmail.setError("Need email");
            etxtEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etxtPassword.setError("Need password");
            etxtPassword.requestFocus();
        }else{
            Log.d("Gustav", "createUser: "+ email + " " + password);
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(SignupActivity.this, "Created user", Toast.LENGTH_SHORT).show();
                finish();
                }
            });

        }
    }



}