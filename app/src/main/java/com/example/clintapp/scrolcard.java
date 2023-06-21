package com.example.clintapp;

import static com.example.clintapp.login.PREFS_NAM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.squareup.picasso.Picasso;

public class scrolcard extends AppCompatActivity {

    ImageView image1,image3;
    CardView cardView,cardView2;
    TextView solo,pricepool,solo2 ,date2;
    FirebaseRemoteConfig firebaseRemoteConfig;
    String newversion;
    String currentversiom ="1";
    String pagelink;
    private static int splashtimeout = 3000;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolcard);

        cardView =findViewById(R.id.cardview1);
        solo=findViewById(R.id.solo);
        pricepool=findViewById(R.id.pricepool);
        cardView2 = findViewById(R.id.cardView2);
        solo2 =findViewById(R.id.solo2);
        date2=findViewById(R.id.date2);




        FirebaseDatabase database = FirebaseDatabase.getInstance();
        image1 = findViewById(R.id.image2);
        database.getReference().child("image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(image1);
//                Toast.makeText(scrolcard.this, "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(scrolcard.this, "Faielded", Toast.LENGTH_SHORT).show();

            }
        });

        FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        image3 = findViewById(R.id.image3);
        database2.getReference().child("image2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(image3);
//                Toast.makeText(scrolcard.this, "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(scrolcard.this, "Faielded", Toast.LENGTH_SHORT).show();

            }
        });



        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scrolcard.this,MainActivity.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scrolcard.this,main2.class);
                startActivity(intent);
            }
        });


        solo();
        solo2();
        pricepool();
        getupdate();
        updatepage();
        date2();





        //cod for getcurent update
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (newversion.equals(currentversiom)){

                }else{
                    showdialoga();
                }

            }
        },splashtimeout);
//
//
//        //MY CODE {
//       boolean i= newversion.equals(currentversiom);

//        if(){
//
//            showdialoga();
//        }







    }//end of the appcompact activity





    private void showdialoga() {
         AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("new update available")
                .setMessage("Update Now " +
                        "please download new version")
                .setPositiveButton("update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(pagelink)));

                        }catch (Exception e){
                            Toast.makeText(scrolcard.this, "something want wrog try again", Toast.LENGTH_SHORT).show();
                        }

                    }
                }).show();
        dialog.setCancelable(false);

    }



  //end of this code
  private void getupdate() {
      FirebaseDatabase fire = FirebaseDatabase.getInstance();
      DatabaseReference data = fire.getReference("newupdateapp");

      data.addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              if (snapshot.exists()) {
                   newversion = snapshot.getValue().toString();

              }
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });
  }

    private void updatepage() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("updatepage");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    pagelink = snapshot.getValue().toString();



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void solo() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("solo");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    solo.setText(snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




    private void pricepool() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("picepool");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    pricepool.setText(snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void solo2() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("solo2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    solo2.setText(snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void date2() {
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference data = fire.getReference("date2");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    date2.setText(snapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }





}