package com.example.clintapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    EditText email,password;
    Button login;

    private FirebaseAuth th;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginn);




         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent loginnext = new Intent(SignUp.this,login.class);
                 startActivity(loginnext);
             }
         });



    }



    public void summit(View view){
        String emails = email.getText().toString();
        String passwords = password.getText().toString();
        th=FirebaseAuth.getInstance();

        th.createUserWithEmailAndPassword(emails,passwords).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    email.setText("");
                    password.setText("");
                    Toast.makeText(getApplicationContext(), "Succesfull", Toast.LENGTH_SHORT).show();
                    Intent loginpage = new Intent(SignUp.this,login.class);
                    startActivity(loginpage);

                    finish();
                }else{
                    email.setText("");
                    password.setText("");
                    Toast.makeText(getApplicationContext(), "faild", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}