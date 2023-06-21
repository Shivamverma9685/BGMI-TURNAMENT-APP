package com.example.clintapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class pay2 extends AppCompatActivity {
    EditText bgminame2,upi2,number2;
    ImageView qrcode2;
    FirebaseDatabase database;
    DatabaseReference data;
    String BGMIname2,upiref2,number22;

    Button pay2,info2,help2;
    Uri uri;


    String BGMInames,upirefs,numbers;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);

        qrcode2=findViewById(R.id.qrcode2);
        pay2 = findViewById(R.id.pay2);


        info2=findViewById(R.id.info2);
        help2=findViewById(R.id.help2);
//        procees();


        help2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginnext = new Intent(pay2.this,help.class);
                startActivity(loginnext);
            }
        });
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procees();
            }
        });

        database = FirebaseDatabase.getInstance();

        database.getReference().child("QRcode2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(qrcode2);
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Faielded", Toast.LENGTH_SHORT).show();

            }
        });




    }




    public void procees() {
        upi2=findViewById(R.id.payid2);
        number2=findViewById(R.id.number2);
        bgminame2=findViewById(R.id.bgminame2);
        BGMInames = bgminame2.getText().toString().trim();
        upirefs = upi2.getText().toString().trim();
        numbers = number2.getText().toString().trim();

        dataclasse dataclasse = new dataclasse(numbers,upirefs,BGMInames);
        data = FirebaseDatabase.getInstance().getReference(BGMInames);
        data.push().setValue(dataclasse).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                bgminame2.setText(" ");
                upi2.setText(" ");
                number2.setText(" ");
                BGMIname2 = " ";
                upiref2 = " ";
                number22 = " ";

                Toast.makeText(pay2.this, "Successful register", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
