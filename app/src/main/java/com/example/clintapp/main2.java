package com.example.clintapp;

import static com.example.clintapp.login.PREFS_NAM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class main2 extends AppCompatActivity {
    Toolbar toolbar2;

    TextView upload2,reference2,slots2,match_category2,match_date2,room_id2,password2,price2,match_type2;
    Button register2;

    ImageView image12;
    FirebaseDatabase database;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        upload2 = findViewById(R.id.uploadtime2);
        reference2 = findViewById(R.id.reference2);
        slots2 = findViewById(R.id.slots2);
        match_category2 = findViewById(R.id.category2);
        match_date2 = findViewById(R.id.matchdate2);
        room_id2 = findViewById(R.id.roomid2);
        password2 = findViewById(R.id.password2);
        price2 = findViewById(R.id.price2);
        match_type2 = findViewById(R.id.matchtype2);
        register2 = findViewById(R.id.register2);



//
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(main2.this,pay2.class);
                startActivity(intent);
            }
        });

        database = FirebaseDatabase.getInstance();
        image12 = findViewById(R.id.image2);
        database.getReference().child("image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(image12);
//                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(MainActivity.this, "Faielded", Toast.LENGTH_SHORT).show();

            }
        });




        uploadtime();
        reference();
        slots();
        match_category();
        match_date();
        room_id();
        password();
        price();
        match_type();








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.toolbarmenu,menu);
//            new MenuInflater(this).inflate(R.menu.toolbarmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.myfrofile:
                Toast.makeText(this, "empity", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences =getSharedPreferences(PREFS_NAM,0);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putBoolean("hashloged",false);

                editor.commit();
                Intent intent = new Intent(main2.this,SignUp.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void uploadtime() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("Uploadtime2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    upload2.setText("match time : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void reference() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("referenceid2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    reference2.setText("Reference ID : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void slots() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("slots2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    slots2.setText("Slots : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void match_category() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("matchcategory2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    match_category2.setText("match_category : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void  match_date() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("matchdate2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    match_date2.setText("match_date : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void room_id() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("roomid2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    room_id2.setText("room_id : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void password() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("password2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    password2.setText("Password : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void price() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("price2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    price2.setText("Price : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void  match_type() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("matchtype2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    match_type2.setText("match_type : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}