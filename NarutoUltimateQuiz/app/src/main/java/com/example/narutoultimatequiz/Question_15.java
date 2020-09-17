package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_15 extends AppCompatActivity {

    Button btnNext15;
    Button btnPrevious15;
    RadioButton question15_wrong1;
    RadioButton question15_wrong2;
    RadioButton question15_wrong3;
    RadioButton question15_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_15);

        btnNext15 = findViewById(R.id.btnNext15);
        btnPrevious15 = findViewById(R.id.btnPrevious15);
        question15_wrong1 = findViewById(R.id.question15_wrong1);
        question15_wrong2 = findViewById(R.id.question15_wrong2);
        question15_wrong3 = findViewById(R.id.question15_wrong3);
        question15_correct = findViewById(R.id.question15_correct);

        question15_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext15.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[15]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question15_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[15]=true;
                }
                else{
                    MyApplication.answered[15]=false;
                }
                startActivity(new Intent(Question_15.this,Genin.class));
            }
        });


    }
}
