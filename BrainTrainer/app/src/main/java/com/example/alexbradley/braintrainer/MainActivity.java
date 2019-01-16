package com.example.alexbradley.braintrainer;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    Button goButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score = 0;
    int numberOfQuestions = 0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout;

    public void playAgain(View view) {
        gameLayout.setVisibility(View.INVISIBLE);
        goButton.setVisibility(View.VISIBLE);
        resultTextView.setText("");
    }

    public void chooseAnswer(View view) {
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            Log.i("Correct", "Correct");
            resultTextView.setText("Correct");
            score++;
        }
        else {
            Log.i("Wrong", "Wrong");
            resultTextView.setText("Wrong");

        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestion();
    }

    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestion();

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Time's up!");
                playAgainButton.setVisibility(View.VISIBLE);
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
            }

        }.start();
    }

    public void newQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a+b);
            }
            else {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a+b) {
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);

            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        gameLayout = findViewById(R.id.gameLayout);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        playAgainButton = findViewById(R.id.playAgainButton);

        goButton = findViewById(R.id.goButton);

        newQuestion();

        playAgain(findViewById(R.id.timerTextView));

    }
}
