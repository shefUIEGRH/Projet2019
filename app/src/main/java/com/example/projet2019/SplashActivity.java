package com.example.projet2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.projet2019.activités.MainActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread myThread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();
    }
}
