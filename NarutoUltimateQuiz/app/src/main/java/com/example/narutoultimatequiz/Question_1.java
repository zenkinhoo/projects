package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_1 extends AppCompatActivity {

    Button btnNext1;
    RadioButton question1_wrong1;
    RadioButton question1_wrong2;
    RadioButton question1_wrong3;
    RadioButton question1_correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_1);
        // inicijalizacija komponenti
        btnNext1 = findViewById(R.id.btnNext1);

        question1_wrong1 = findViewById(R.id.question1_wrong1);
        question1_wrong2 = findViewById(R.id.question1_wrong2);
        question1_wrong3 = findViewById(R.id.question1_wrong3);
        question1_correct = findViewById(R.id.question1_correct);
        question1_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnNext1.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[1]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question1_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[1]=true;
                }
                else{
                    MyApplication.answered[1]=false;
                }
                startActivity(new Intent(Question_1.this,Question_2.class));
            }
        });
    }





}
