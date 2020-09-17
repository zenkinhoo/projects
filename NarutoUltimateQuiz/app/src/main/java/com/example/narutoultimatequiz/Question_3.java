package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_3 extends AppCompatActivity {

    Button btnNext3;
    Button btnPrevious3;
    RadioButton question3_wrong1;
    RadioButton question3_wrong2;
    RadioButton question3_wrong3;
    RadioButton question3_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_3);

        btnNext3 = findViewById(R.id.btnNext3);
        btnPrevious3 = findViewById(R.id.btnPrevious3);
        question3_wrong1 = findViewById(R.id.question3_wrong1);
        question3_wrong2 = findViewById(R.id.question3_wrong2);
        question3_wrong3 = findViewById(R.id.question3_wrong3);
        question3_correct = findViewById(R.id.question3_correct);

        question3_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext3.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[3]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question3_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[3]=true;
                }
                else{
                    MyApplication.answered[3]=false;
                }
                startActivity(new Intent(Question_3.this,Question_4.class));
            }
        });
    }
}
