package com.example.clintapp;





import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class login extends AppCompatActivity {

 public static final String PREFS_NAM = "prefs";

    EditText emaill,passwordl;
    private Button login2;
    private FirebaseAuth thl;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login2 =findViewById(R.id.login);
        emaill = findViewById(R.id.emaill);
        passwordl = findViewById(R.id.passwordl);




        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emaills=emaill.getText().toString();
                String passwordls=passwordl.getText().toString();
                thl = FirebaseAuth.getInstance();


                thl.signInWithEmailAndPassword(emaills,passwordls).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            SharedPreferences sharedPreferences =getSharedPreferences(PREFS_NAM,0);
                            SharedPreferences.Editor editor =sharedPreferences.edit();
                            editor.putBoolean("hashloged",true);
                            editor.commit();
                            emaill.setText("");
                            passwordl.setText("");
                            Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                            Intent Mainactive = new Intent(login.this,MainActivity.class);
                            startActivity(Mainactive);

                            finish();


                        }else{
                            emaill.setText("");
                            passwordl.setText("");
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });



            }
        });





    }












    //public void summitl(View view){
//        String emaills=emaill.getText().toString();
//        String passwordls=passwordl.getText().toString();
//        thl = FirebaseAuth.getInstance();
//
//
//    thl.signInWithEmailAndPassword(emaills,passwordls).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
//        @Override
//        public void onComplete(@NonNull Task<AuthResult> task) {
//
//            if(task.isSuccessful()){
//                emaill.setText("");
//                passwordl.setText("");
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
//                Intent Mainactive = new Intent(login.this,MainActivity.class);
//                startActivity(Mainactive);
//
//                finish();
//
//
//            }else{
//                emaill.setText("");
//                passwordl.setText("");
//                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
//
//            }
//        }
//    });
//
//
//
//
//}



}