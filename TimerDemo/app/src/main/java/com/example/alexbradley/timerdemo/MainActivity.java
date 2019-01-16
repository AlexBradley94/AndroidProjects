package com.example.alexbradley.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000) {
            public void onTick(long millisecondsUntilDone) {
                Log.i("Countdown status", String.valueOf(millisecondsUntilDone/1000) + " seconds left");
            }

            public void onFinish() {
                Log.i("Countdown status", "Finished");
            }
        }.start();

        /*
        final Handler handler = new Handler();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Test timer", "1 second");

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run);
        */
    }
}
