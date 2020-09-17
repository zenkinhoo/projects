package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_8 extends AppCompatActivity {

    Button btnNext8;
    Button btnPrevious8;
    RadioButton question8_wrong1;
    RadioButton question8_wrong2;
    RadioButton question8_wrong3;
    RadioButton question8_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_8);

        btnNext8 = findViewById(R.id.btnNext8);
        btnPrevious8 = findViewById(R.id.btnPrevious8);
        question8_wrong1 = findViewById(R.id.question8_wrong1);
        question8_wrong2 = findViewById(R.id.question8_wrong2);
        question8_wrong3 = findViewById(R.id.question8_wrong3);
        question8_correct = findViewById(R.id.question8_correct);

        question8_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext8.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[8]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question8_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[8]=true;
                }
                else{
                    MyApplication.answered[8]=false;
                }
                startActivity(new Intent(Question_8.this,Question_9.class));
            }
        });
    }
}
