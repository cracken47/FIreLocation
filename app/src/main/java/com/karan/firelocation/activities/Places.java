package com.karan.firelocation.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.karan.firelocation.R;
import com.karan.firelocation.activities.MapsActivity;

public class Places extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        //tajmahal - 27.1751 , 78.0421
        //india gate - 28.6129, 28.6129
        //gateway of india  - 18.9220, 72.8347
        //srinagar - 34.0837 , 34.0837
        //margao - 15.2832 ,73.9862
        //pondicherry -11.9416 , 79.8083
        //hyderabad - 17.3850 , 78.4867
        //kolkata - 22.5726 , 22.5726
        //patna - 25.5941 , 85.1376
        //guwahati - 26.1445 , 91.7362

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            // Permission already Granted
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        CardView indiagate = findViewById(R.id.indiagate);
        CardView gatewayofindia = findViewById(R.id.gatewayofindia);
        CardView srinagar = findViewById(R.id.srinagar);
        CardView patna= findViewById(R.id.patna);
        CardView margao = findViewById(R.id.margao);
        CardView hyderabad= findViewById(R.id.hyderabad);
        CardView kolkata = findViewById(R.id.kolkata);
        CardView guwahati = findViewById(R.id.guwahati);
        CardView pondicherry = findViewById(R.id.pondicherry);
        CardView tajmahal = findViewById(R.id.tajmahal);
        tajmahal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("lattitude",27.1751);
                i.putExtra("longitude",78.0421);
                i.putExtra("tajmahal",1);
                startActivity(i);
            }
        });
        indiagate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude",28.6129);
                i.putExtra("longitude",28.6129);
                i.putExtra("indiagate",2);
                startActivity(i);

            }
        });
        gatewayofindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude",18.9220);
                i.putExtra("longitude",72.8347);
                i.putExtra("gatewayofindia",3);
                startActivity(i);

            }
        });
        srinagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude",34.0837);
                i.putExtra("longitude",34.0837);
                i.putExtra("srinagar",4);
                startActivity(i);

            }
        });
        kolkata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude", 22.5726);
                i.putExtra("longitude",22.5726);
                i.putExtra("kolkata",5);
                startActivity(i);
            }
        });
        guwahati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude",26.1445);
                i.putExtra("longitude",91.7362);
                i.putExtra("guwahati",6);
                startActivity(i);
            }
        });
        pondicherry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude",11.9416 );
                i.putExtra("longitude",79.8083);
                i.putExtra("pondicherry",7);
                startActivity(i);
            }
        });
        margao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude",15.2832);
                i.putExtra("longitude",73.9862);
                i.putExtra("margao",8);
                startActivity(i);
            }
        });
        patna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("lattitude",25.5941);
                i.putExtra("longitude",85.1376);
                i.putExtra("patna",9);
                startActivity(i);
            }
        });
       hyderabad.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(),MapsActivity.class);
               i.putExtra("lattitude",17.3850);
               i.putExtra("longitude", 78.4867);
               i.putExtra("hyderabad",10);
               startActivity(i);
           }
       });


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Permission Granted
                //Do your work here
//Perform operations here only which requires permission
            }
        }
    }
}
