package com.example.alexbradley.showhide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showHideText;
    Button showHideBtn;
    Boolean visible;

    public void showHide(View view) {
        if (visible) {
            showHideText.setVisibility(View.INVISIBLE);

            visible = false;
            showHideBtn.setText("SHOW");
        }
        else {
            showHideText.setVisibility(View.VISIBLE);

            visible = true;
            showHideBtn.setText("HIDE");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showHideText = findViewById(R.id.showHideText);
        showHideBtn = findViewById(R.id.showHideBtn);

        visible = false;
    }
}
