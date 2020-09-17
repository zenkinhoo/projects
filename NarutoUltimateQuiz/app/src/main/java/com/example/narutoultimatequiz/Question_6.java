package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_6 extends AppCompatActivity {

    Button btnNext6;
    Button btnPrevious6;
    RadioButton question6_wrong1;
    RadioButton question6_wrong2;
    RadioButton question6_wrong3;
    RadioButton question6_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_6);

        btnNext6 = findViewById(R.id.btnNext6);
        btnPrevious6 = findViewById(R.id.btnPrevious6);
        question6_wrong1 = findViewById(R.id.question6_wrong1);
        question6_wrong2 = findViewById(R.id.question6_wrong2);
        question6_wrong3 = findViewById(R.id.question6_wrong3);
        question6_correct = findViewById(R.id.question6_correct);

        question6_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnNext6.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[6]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question6_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[6]=true;
                }
                else{
                    MyApplication.answered[6]=false;
                }
                startActivity(new Intent(Question_6.this,Question_7.class));
            }
        });
    }
}
