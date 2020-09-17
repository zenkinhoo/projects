package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_12 extends AppCompatActivity {

    Button btnNext12;
    Button btnPrevious12;
    RadioButton question12_wrong1;
    RadioButton question12_wrong2;
    RadioButton question12_wrong3;
    RadioButton question12_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_12);

        btnNext12 = findViewById(R.id.btnNext12);
        btnPrevious12 = findViewById(R.id.btnPrevious12);
        question12_wrong1 = findViewById(R.id.question12_wrong1);
        question12_wrong2 = findViewById(R.id.question12_wrong2);
        question12_wrong3 = findViewById(R.id.question12_wrong3);
        question12_correct = findViewById(R.id.question12_correct);

        question12_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext12.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[12]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question12_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[12]=true;
                }
                else{
                    MyApplication.answered[12]=false;
                }
                startActivity(new Intent(Question_12.this,Question_13.class));
            }
        });
    }
}
