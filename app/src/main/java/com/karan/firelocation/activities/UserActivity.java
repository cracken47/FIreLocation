package com.karan.firelocation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.karan.firelocation.R;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Button maps = findViewById(R.id.button);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Places.class));
            }
        });
        Button profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProfileAcitvity.class));
            }
        });
        new SimpleTooltip.Builder(getApplicationContext())
                .anchorView(maps)
                .text("Goto Maps")
                .backgroundColor(Color.rgb(90, 163, 58))
                .arrowColor(Color.rgb(90, 163, 58))
                .gravity(Gravity.BOTTOM)
                .animated(true)
                .overlayMatchParent(true)
                .build()
                .show();
    }
}
