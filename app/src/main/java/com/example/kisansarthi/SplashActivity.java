package com.example.kisansarthi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread thread = new Thread(){ //Threads are used to perform different operations parellel.
            public void run(){
                try{
                    sleep(2000);
                    //getSupportActionBar().hide();

                }catch(Exception e){
                    e.printStackTrace();//Mother of all exceptions.used because we don't know what's the exceptoin gonna occur
                }
                finally {
                   Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                   startActivity(intent);
                   //So that whenever user clicks back,it won't be redirected to
                }
            }
        };
        thread.start();

    }

}
