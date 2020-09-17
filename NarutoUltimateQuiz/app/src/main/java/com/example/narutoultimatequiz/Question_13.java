package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_13 extends AppCompatActivity {

    Button btnNext13;
    Button btnPrevious13;
    RadioButton question13_wrong1;
    RadioButton question13_wrong2;
    RadioButton question13_wrong3;
    RadioButton question13_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_13);

        btnNext13 = findViewById(R.id.btnNext13);
        btnPrevious13 = findViewById(R.id.btnPrevious13);
        question13_wrong1 = findViewById(R.id.question13_wrong1);
        question13_wrong2 = findViewById(R.id.question13_wrong2);
        question13_wrong3 = findViewById(R.id.question13_wrong3);
        question13_correct = findViewById(R.id.question13_correct);

        question13_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext13.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[13]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question13_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[13]=true;
                }
                else{
                    MyApplication.answered[13]=false;
                }
                startActivity(new Intent(Question_13.this,Question_14.class));
            }
        });
    }
}
