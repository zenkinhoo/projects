package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_5 extends AppCompatActivity {

    Button btnNext5;
    Button btnPrevious5;
    RadioButton question5_wrong1;
    RadioButton question5_wrong2;
    RadioButton question5_wrong3;
    RadioButton question5_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_5);

        btnNext5 = findViewById(R.id.btnNext5);
        btnPrevious5 = findViewById(R.id.btnPrevious5);
        question5_wrong1 = findViewById(R.id.question5_wrong1);
        question5_wrong2 = findViewById(R.id.question5_wrong2);
        question5_wrong3 = findViewById(R.id.question5_wrong3);
        question5_correct = findViewById(R.id.question5_correct);

        question5_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNext5.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[5]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question5_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[5]=true;
                }
                else{
                    MyApplication.answered[5]=false;
                }
                startActivity(new Intent(Question_5.this,Question_6.class));
            }
        });
    }
}
