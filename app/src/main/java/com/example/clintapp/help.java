package com.example.clintapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class help extends AppCompatActivity {

    ImageView help1,help2,help3,help4,help5;
    FirebaseDatabase database;
    DatabaseReference data;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        help1 =findViewById(R.id.helpimage1);
        help2 =findViewById(R.id.helpimage2);
        help3 =findViewById(R.id.helpimage3);
        help4 =findViewById(R.id.helpimage4);
        help5 =findViewById(R.id.helpimage5);

      imagesload();



    }

    public void imagesload(){


        database = FirebaseDatabase.getInstance();
        database.getReference().child("helpimage1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(help1);
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Faielded", Toast.LENGTH_SHORT).show();

            }
        });

        database = FirebaseDatabase.getInstance();
        database.getReference().child("helpimage5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(help5);
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Faielded", Toast.LENGTH_SHORT).show();

            }
        });


        database = FirebaseDatabase.getInstance();
        database.getReference().child("helpimage2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(help2);
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Faielded", Toast.LENGTH_SHORT).show();

            }
        });


        database = FirebaseDatabase.getInstance();
        database.getReference().child("helpimage3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(help3);
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Faielded", Toast.LENGTH_SHORT).show();

            }
        });




        database = FirebaseDatabase.getInstance();
        database.getReference().child("helpimage4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(help4);
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Faielded", Toast.LENGTH_SHORT).show();

            }
        });


    }
}