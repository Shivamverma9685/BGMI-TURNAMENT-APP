package com.example.clintapp;

import static com.example.clintapp.login.PREFS_NAM;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import dev.shreyaspatil.easyupipayment.EasyUpiPayment;
import dev.shreyaspatil.easyupipayment.exception.AppNotFoundException;

public class MainActivity extends AppCompatActivity {
//    TextView name,massage;
//    EditText value;
//    Button btn;
    Toolbar toolbar;

    TextView upload,reference,slots,match_category,match_date,room_id,password,price,match_type;
            Button register;
    // for image code
//    TextView ref;
    ImageView image1;
    FirebaseDatabase database;




    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for remove title bar code
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();



        //toolbar
         toolbar =findViewById(R.id.bar);
         setSupportActionBar(toolbar);
//        toolbar =findViewById(R.id.bar);
//        setSupportActionBar(toolbar);









//        ref=findViewById(R.id.ref);


        upload = findViewById(R.id.uploadtime);
        reference =findViewById(R.id.reference);
        slots = findViewById(R.id.slots);
        match_category =findViewById(R.id.category);
        match_date =findViewById(R.id.matchdate);
        room_id =findViewById(R.id.roomid);
        password =findViewById(R.id.password);
        price =findViewById(R.id.price);
        match_type=findViewById(R.id.matchtype);
        register=findViewById(R.id.register);



        //easy tostor data;
        //ref.setText(""+snapshot.getValue().toString());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(MainActivity.this,payment.class);
               startActivity(intent);
            }
        });



        //image
        database = FirebaseDatabase.getInstance();
        image1 = findViewById(R.id.image);
        database.getReference().child("image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(image1);
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Faielded", Toast.LENGTH_SHORT).show();

            }
        });


//        name = findViewById(R.id.name);
//        massage = findViewById(R.id.massage);
//
//        value = findViewById(R.id.value);
//        btn = findViewById(R.id.btn);
////
//
//
//
//reference,slots,match_category,match_date,room_id,password,price,match_type


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



        //toolbar
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            new MenuInflater(this).inflate(R.menu.toolbarmenu,menu);
            return super.onCreateOptionsMenu(menu);
        }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.myfrofile:
                Toast.makeText(this, "Succesful", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences =getSharedPreferences(PREFS_NAM,0);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putBoolean("hashloged",false);
                editor.commit();
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void uploadtime () {
            FirebaseDatabase fire = FirebaseDatabase.getInstance();
            DatabaseReference data = fire.getReference("uploadtime");

            data.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        upload.setText("Upload time : "+snapshot.getValue().toString());

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    private void reference() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("referenceid");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    reference.setText("Reference ID : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void slots() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("slots");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    slots.setText("Slots : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void match_category() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("matchcategory");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    match_category.setText("match_category : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void  match_date() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("matchdate");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    match_date.setText("match_date : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void room_id() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("roomid");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    room_id.setText("room_id : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void password() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("password");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    password.setText("Password : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void price() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("price");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    price.setText("Price : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void  match_type() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("matchtype");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    match_type.setText("match_type : "+snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }



}
