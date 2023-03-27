package com.example.clintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {
    private static int splashtimeout =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
          //use for skip login with splace screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences =getSharedPreferences(String.valueOf(login.PREFS_NAM),0);
                boolean hashloged =sharedPreferences.getBoolean("hashloged",false);
                Intent intent;
                if(hashloged){
                    intent = new Intent(splashscreen.this, MainActivity.class);
                }else {
                    intent = new Intent(splashscreen.this, SignUp.class);
                }
                startActivity(intent);
                finish();
            }
        },splashtimeout);


    }
}