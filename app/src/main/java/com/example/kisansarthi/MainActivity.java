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
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,CaptureImageActivity.class);
                startActivity(intent2);
            }
            /*@Override
            public void onClick(View view) {
                final int REQUEST_IMAGE_CAPTURE = 1;
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

                } catch (ActivityNotFoundException e) {
                    // display error state to the user
                }

            }*/


        });

    }
}