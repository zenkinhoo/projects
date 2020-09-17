package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_10 extends AppCompatActivity {

    Button btnNext10;
    Button btnPrevious10;
    RadioButton question10_wrong1;
    RadioButton question10_wrong2;
    RadioButton question10_wrong3;
    RadioButton question10_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_10);

        btnNext10 = findViewById(R.id.btnNext10);
        btnPrevious10 = findViewById(R.id.btnPrevious10);
        question10_wrong1 = findViewById(R.id.question10_wrong1);
        question10_wrong2 = findViewById(R.id.question10_wrong2);
        question10_wrong3 = findViewById(R.id.question10_wrong3);
        question10_correct = findViewById(R.id.question10_correct);

        question10_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext10.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[10]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question10_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[10]=true;
                }
                else{
                    MyApplication.answered[10]=false;
                }
                startActivity(new Intent(Question_10.this,Question_11.class));
            }
        });
    }
}
