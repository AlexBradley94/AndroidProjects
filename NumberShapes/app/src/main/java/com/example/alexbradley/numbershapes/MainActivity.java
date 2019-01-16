package com.example.alexbradley.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {

                return true;

            }
            else {

                return false;

            }

        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;

                triangularNumber += x;

            }

            if (triangularNumber == number) {

                return true;

            }
            else {

                return false;

            }

        }

    }

    public void testNumber(View view) {

        Log.i("Info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.editText);

        String message;

        if (editText.getText().toString().isEmpty()) {

            message = "Please enter a number";

        }
        else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(editText.getText().toString());


            if ((myNumber.isTriangular()) && (myNumber.isSquare())) {

                message = myNumber.number + " is a square and triangular number";

            }
            else if (myNumber.isTriangular()) {

                message = myNumber.number + " is a triangular number";

            }
            else if (myNumber.isSquare()) {

                message = myNumber.number + " is a square number";

            }
            else {

                message = myNumber.number + " is neither a square nor triangular number";

            }
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
