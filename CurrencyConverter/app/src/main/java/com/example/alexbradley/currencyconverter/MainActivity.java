package com.example.alexbradley.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view) {
        Log.i("info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.txtAmount);

        String amountInPounds = editText.getText().toString();

        double amountInPoundsDouble = Double.parseDouble(amountInPounds);

        double amountInDollarsDouble = amountInPoundsDouble*1.3;

        String amountInDollarsString = String.format("%.2f", amountInDollarsDouble);

        Log.i("Info", editText.getText().toString());

        Toast.makeText(this, "£"+amountInPoundsDouble+" is $"+amountInDollarsString, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
