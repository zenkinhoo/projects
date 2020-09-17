package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    TextView txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        txtScore = findViewById(R.id.txtScore);
        txtScore.setText("Your score is: "+MyApplication.getPoints());
    }
}
