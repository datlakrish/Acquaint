package com.verity.datlashiv.acquaint;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {

    private EditText login_email, login_pass;
    private Button login_btn, login_reg, fb_btn, google_btn;
    private FirebaseAuth mAuth;
    private TextView login_forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        init();

        mAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_email.getText().toString().trim().isEmpty()) {
                    login_email.requestFocus();
                    login_email.setError("please provide email id");

                } else if (login_pass.getText().toString().isEmpty()) {
                    login_pass.requestFocus();
                    login_pass.setError("please provide password");

                } else {
                    String email = login_email.getText().toString().trim();
                    String pass = login_pass.getText().toString().trim();

                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(mainIntent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            }
        });

        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(regIntent);
                finish();
            }
        });

        login_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Forget Password", Toast.LENGTH_SHORT).show();
            }
        });

        fb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "FaceBook button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        google_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Google button clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void init() {

        login_email = findViewById(R.id.login_email);
        login_pass = findViewById(R.id.login_pass);
        login_btn = findViewById(R.id.login_btn);
        login_reg = findViewById(R.id.login_reg_btn);
        login_forget = findViewById(R.id.login_forgot);
        fb_btn = findViewById(R.id.fb_btn);
        google_btn = findViewById(R.id.google_btn);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }
}
