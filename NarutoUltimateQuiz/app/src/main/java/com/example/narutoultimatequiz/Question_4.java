package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_4 extends AppCompatActivity {

    Button btnNext4;
    Button btnPrevious4;
    RadioButton question4_wrong1;
    RadioButton question4_wrong2;
    RadioButton question4_wrong3;
    RadioButton question4_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_4);

        btnNext4 = findViewById(R.id.btnNext4);
        btnPrevious4 = findViewById(R.id.btnPrevious4);
        question4_wrong1 = findViewById(R.id.question4_wrong1);
        question4_wrong2 = findViewById(R.id.question4_wrong2);
        question4_wrong3 = findViewById(R.id.question4_wrong3);
        question4_correct = findViewById(R.id.question4_correct);

        question4_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNext4.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[4]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question4_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[4]=true;
                }
                else{
                    MyApplication.answered[4]=false;
                }
                startActivity(new Intent(Question_4.this,Question_5.class));
            }
        });
    }
}
