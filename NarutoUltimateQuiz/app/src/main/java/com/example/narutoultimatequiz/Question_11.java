package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_11 extends AppCompatActivity {

    Button btnNext11;
    Button btnPrevious11;
    RadioButton question11_wrong1;
    RadioButton question11_wrong2;
    RadioButton question11_wrong3;
    RadioButton question11_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_11);

        btnNext11 = findViewById(R.id.btnNext11);
        btnPrevious11 = findViewById(R.id.btnPrevious11);
        question11_wrong1 = findViewById(R.id.question11_wrong1);
        question11_wrong2 = findViewById(R.id.question11_wrong2);
        question11_wrong3 = findViewById(R.id.question11_wrong3);
        question11_correct = findViewById(R.id.question11_correct);

        question11_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext11.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[11]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question11_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[11]=true;
                }
                else{
                    MyApplication.answered[11]=false;
                }
                startActivity(new Intent(Question_11.this,Question_12.class));
            }
        });
    }
}
