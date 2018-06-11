package com.verity.datlashiv.acquaint;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_name, reg_email, reg_pass;
    private Button reg_btn, reg_login_btn;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;
    private ArrayList<Model> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();
        init();

        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("user");
        modelArrayList = new ArrayList<>();

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (reg_name.getText().toString().trim().isEmpty()) {
                    reg_name.requestFocus();
                    reg_name.setError("provide username");

                } else if (reg_email.getText().toString().trim().isEmpty()) {
                    reg_email.requestFocus();
                    reg_email.setError("provide email id");

                } else if (reg_pass.getText().toString().isEmpty()) {
                    reg_pass.requestFocus();
                    reg_pass.setError("provide password");

                } else {
                    String user = reg_name.getText().toString().trim();
                    String email = reg_email.getText().toString().trim();
                    String pass = reg_pass.getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(loginIntent);
                                finish();
//                                Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
//
                            } else {

                                Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    String id = reference.push().getKey();
                    Model model = new Model(id, user, email, pass);
                    reference.child(id).setValue(model);


                }
            }
        });


        reg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });
    }

    public void init() {
        reg_name = findViewById(R.id.reg_user);
        reg_email = findViewById(R.id.reg_email);
        reg_pass = findViewById(R.id.reg_pass);
        reg_btn = findViewById(R.id.reg_btn);
        reg_login_btn = findViewById(R.id.reg_login_btn);
    }
}
