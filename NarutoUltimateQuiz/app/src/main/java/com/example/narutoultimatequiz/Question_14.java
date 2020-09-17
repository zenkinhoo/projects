package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_14 extends AppCompatActivity {

    Button btnNext14;
    Button btnPrevious14;
    RadioButton question14_wrong1;
    RadioButton question14_wrong2;
    RadioButton question14_wrong3;
    RadioButton question14_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_14);

        btnNext14 = findViewById(R.id.btnNext14);
        btnPrevious14 = findViewById(R.id.btnPrevious14);
        question14_wrong1 = findViewById(R.id.question14_wrong1);
        question14_wrong2 = findViewById(R.id.question14_wrong2);
        question14_wrong3 = findViewById(R.id.question14_wrong3);
        question14_correct = findViewById(R.id.question14_correct);

        question14_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext14.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[14]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question14_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[14]=true;
                }
                else{
                    MyApplication.answered[14]=false;
                }
                startActivity(new Intent(Question_14.this,Question_15.class));
            }
        });
    }
}
