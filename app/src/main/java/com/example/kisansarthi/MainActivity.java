package com.example.kisansarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Button b1;
        b1 = findViewById(R.id.Experts);
        boolean l = true;
        if(l == true){
            b1.setVisibility(View.VISIBLE);
        }
        */
        Button b1 = (Button) findViewById(R.id.Kisan);
        Button b2 = (Button) findViewById(R.id.Sarthi);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,FarmerActivity.class);
                    startActivity(intent);
            }
        });



    }
}