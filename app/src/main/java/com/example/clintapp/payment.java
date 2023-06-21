package com.example.clintapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;
import com.squareup.picasso.Picasso;

public class payment extends AppCompatActivity {

    EditText bgminame,upi;
    ImageView qrcode;
    FirebaseDatabase database;
    DatabaseReference data;
    String BGMIname,upiref;

    Button pay,info;
    Uri uri;
    public static final String paytm_packagename = "net.one97.paytm";


    String GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
//    int GOOGLE_PAY_REQUEST_CODE = 123;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK && data.getData() != null) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }

    }


    ActivityResultLauncher<Intent> StartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

        }
    });

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        qrcode=findViewById(R.id.qrcode);
        pay = findViewById(R.id.pay);
        bgminame=findViewById(R.id.bgminame);
        upi=findViewById(R.id.payid);
        info=findViewById(R.id.info);


        //data fetch form database





            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        BGMIname=bgminame.getText().toString();
                        upiref = upi.getText().toString();
                    data = FirebaseDatabase.getInstance().getReference(BGMIname);
                    data.push().setValue(upiref).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            bgminame.setText(" ");
                            upi.setText(" ");
                            BGMIname=" ";
                            upiref = " ";

                            Toast.makeText(payment.this, "Successful register", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    uri = pay();
                    paywith(paytm_packagename);
//                    pay();




            }
        });



        //image
        //image
        database = FirebaseDatabase.getInstance();

        database.getReference().child("QRcode").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String images = snapshot.getValue(String.class);
                Picasso.get().load(images).into(qrcode);
//                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Faielded", Toast.LENGTH_SHORT).show();

            }
        });




    }

















        private static Uri pay() {
        return new Uri.Builder().scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa","bgmigaming9911@apl")//kamesh g =kameshprajapati2001@oksbi
//                .appendQueryParameter("pn","kamesh prajapatti")
//                .appendQueryParameter("tn","example")
//                .appendQueryParameter("am","1")
                .appendQueryParameter("cu","INR")
                .build();


    }

    private void paywith(String pakagename){
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        intent.setPackage(paytm_packagename);
//        startActivityForResult(intent,0);
        Intent choser = Intent.createChooser(intent,"Pay with");
         StartForResult.launch(choser);

    }




//    public void pay() throws AppNotFoundException {



//        EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder(payment.this)
//                .setPayeeName("shiva")
//                .setPayeeVpa("01shivaarya@oksbi")
//                .setDescription("hay")
//                .setAmount("10")
//                .setTransactionId("64738292384437")
//                .setTransactionRefId("3264374329822");
//        EasyUpiPayment upi = builder.build();
//        upi.startPayment();


//        Float values = Float.valueOf("10.00");
//        Uri uri =
//                new Uri.Builder()
//                        .scheme("upi")
//                        .authority("pay")
//                        .appendQueryParameter("pa", "") //7869925045
//                        .appendQueryParameter("pn", "Arun Arya")
//                        .appendQueryParameter("mc", "dsfsd")
//                        .appendQueryParameter("tr", "9876")
//                        .appendQueryParameter("tn", "example")
//                        .appendQueryParameter("am", String.valueOf(values))
//                        .appendQueryParameter("cu", "INR")
//                        .appendQueryParameter("url", "your-transaction-url")
//                        .build();
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(uri);
//        Intent choser = Intent.createChooser(intent,"Pay with");
//        StartForResult.launch(choser);



//    }
}