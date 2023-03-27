package com.example.clintapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.annotations.Nullable;

public class payment extends AppCompatActivity {

    EditText bgminame;

    Button pay;
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

        pay = findViewById(R.id.pay);
        bgminame=findViewById(R.id.bgminame);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    uri =pay();
                    paywith(paytm_packagename);
//                    pay();




            }
        });

    }

















        private static Uri pay() {
        return new Uri.Builder().scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa","")
//                .appendQueryParameter("pn","")
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
//                .setPayeeName("name")
//                .setPayeeVpa("upiid")
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
//                        .appendQueryParameter("pa", "")
//                        .appendQueryParameter("pn", "name")
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