package com.karan.firelocation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.karan.firelocation.Utilities.ConnectionDetector;
import com.karan.firelocation.R;
import com.karan.firelocation.Utilities.SavedSharedPreferences;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    ConnectionDetector mConnectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        mConnectionDetector = new ConnectionDetector(getApplicationContext());
        if (!mConnectionDetector.isConnectingToInternet()) {
            Toast.makeText(getApplicationContext(), "Please connect to internet first", Toast.LENGTH_LONG).show();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (SavedSharedPreferences.getFirebaseid(SplashScreen.this.getApplicationContext()).length() == 0) {
                        Intent i = new Intent(SplashScreen.this.getApplicationContext(), MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        SplashScreen.this.startActivity(i);
                        SplashScreen.this.finish();
                    } else {
                        //TODO start CategoryActivity here
                        SplashScreen.this.startActivity(new Intent(SplashScreen.this.getApplicationContext(), UserActivity.class));
                        SplashScreen.this.finish();
                    }
                }
            }, SPLASH_TIME_OUT);
        }
    }
}

