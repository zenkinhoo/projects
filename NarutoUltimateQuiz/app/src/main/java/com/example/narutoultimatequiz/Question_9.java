package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_9 extends AppCompatActivity {

    Button btnNext9;
    Button btnPrevious9;
    RadioButton question9_wrong1;
    RadioButton question9_wrong2;
    RadioButton question9_wrong3;
    RadioButton question9_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_9);

        btnNext9 = findViewById(R.id.btnNext9);
        btnPrevious9 = findViewById(R.id.btnPrevious9);
        question9_wrong1 = findViewById(R.id.question9_wrong1);
        question9_wrong2 = findViewById(R.id.question9_wrong2);
        question9_wrong3 = findViewById(R.id.question9_wrong3);
        question9_correct = findViewById(R.id.question9_correct);

        question9_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext9.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[9]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question9_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[9]=true;
                }
                else{
                    MyApplication.answered[9]=false;
                }
                startActivity(new Intent(Question_9.this,Question_10.class));
            }
        });
    }
}
