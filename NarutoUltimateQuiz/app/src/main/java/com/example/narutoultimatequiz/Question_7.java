package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_7 extends AppCompatActivity {

    Button btnNext7;
    Button btnPrevious7;
    RadioButton question7_wrong1;
    RadioButton question7_wrong2;
    RadioButton question7_wrong3;
    RadioButton question7_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_7);

        btnNext7 = findViewById(R.id.btnNext7);
        btnPrevious7 = findViewById(R.id.btnPrevious7);
        question7_wrong1 = findViewById(R.id.question7_wrong1);
        question7_wrong2 = findViewById(R.id.question7_wrong2);
        question7_wrong3 = findViewById(R.id.question7_wrong3);
        question7_correct = findViewById(R.id.question7_correct);

        question7_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext7.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[7]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question7_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[7]=true;
                }
                else{
                    MyApplication.answered[7]=false;
                }
                startActivity(new Intent(Question_7.this,Question_8.class));
            }
        });
    }


}
