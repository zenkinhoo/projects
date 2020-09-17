package com.example.narutoultimatequiz;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_2 extends AppCompatActivity {

    Button btnNext2;
    Button btnPrevious2;
    RadioButton question2_wrong1;
    RadioButton question2_wrong2;
    RadioButton question2_wrong3;
    RadioButton question2_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_2);

        btnNext2 = findViewById(R.id.btnNext2);
        btnPrevious2 = findViewById(R.id.btnPrevious2);
        question2_wrong1 = findViewById(R.id.question2_wrong1);
        question2_wrong2 = findViewById(R.id.question2_wrong2);
        question2_wrong3 = findViewById(R.id.question2_wrong3);
        question2_correct = findViewById(R.id.question2_correct);

        question2_wrong1.setChecked(true);
        Log.d("Broj poena: ", "value" +  MyApplication.getPoints());


        btnPrevious2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    finish();
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() { // dugme za prelazak na sledece pitanje
            @Override
            public void onClick(View v) {
                if(MyApplication.answered[2]) //vec je odgovarano tacno na pitanje
                {
                    MyApplication.decrementPoints();
                }
                if(question2_correct.isChecked())
                {
                    MyApplication.incrementPoints();
                    MyApplication.answered[2]=true;
                }
                else{
                    MyApplication.answered[2]=false;
                }
                startActivity(new Intent(Question_2.this,Question_3.class));
            }
        });

    }

}
