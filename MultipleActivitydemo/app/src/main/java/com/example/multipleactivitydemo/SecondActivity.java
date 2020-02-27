package com.example.multipleactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public void goBack(View view) {
        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        /*Intent intent = getIntent();
        int age = intent.getIntExtra("Age", 0);

        Toast.makeText(this, Integer.toString(age), Toast.LENGTH_SHORT).show();*/
    }
}
