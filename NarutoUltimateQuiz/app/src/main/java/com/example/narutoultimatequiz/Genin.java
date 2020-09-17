package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Genin extends AppCompatActivity {

    TextView txtGenScore;
    TextView txtRank;
    TextView txtScore;
    TextView txtPercentage;
    Button btnMainMenu;
    ImageView imgRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genin);

        txtGenScore = findViewById(R.id.txtGenScore);
        txtRank = findViewById(R.id.txtRank);
        txtScore = findViewById(R.id.txtScore);
        txtPercentage = findViewById(R.id.txtPercentage);
        btnMainMenu = findViewById(R.id.btnMainMenu);
        imgRank = findViewById(R.id.imgRank);

        txtScore.setText("Score: "+MyApplication.getPoints()+"/15");
        txtPercentage.setText("Percentage: "+Math.round((double)MyApplication.getPoints()/15*100)+"%");
        if(MyApplication.getPoints()<=5)
        {
            imgRank.setImageResource(R.drawable.genin);
            txtGenScore.setText("You can do it better "+MyApplication.getNickname());
            txtRank.setText("Rank: Genin");
        }
        else if (MyApplication.getPoints()>5 && MyApplication.getPoints()<=8)
        {
            imgRank.setImageResource(R.drawable.chunin);
            txtGenScore.setText("Good but not perfect "+MyApplication.getNickname());
            txtRank.setText("Rank: Chunin");
        }
        else if (MyApplication.getPoints()>8 && MyApplication.getPoints()<=11)
        {
            imgRank.setImageResource(R.drawable.jounin);
            txtGenScore.setText("Congratulations , you have become Jounin "+MyApplication.getNickname());
            txtRank.setText("Rank: Jounin");
        }
        else if (MyApplication.getPoints()>11 && MyApplication.getPoints()<=13)
        {
            imgRank.setImageResource(R.drawable.sannin);
            txtGenScore.setText("Excellent , you are an elite ninja "+MyApplication.getNickname());
            txtRank.setText("Rank: Sannin");
        }
        else
        {
            imgRank.setImageResource(R.drawable.kage);
            txtGenScore.setText("You are truly legendary shinobi "+MyApplication.getNickname());
            txtRank.setText("Rank: Kage");
        }

        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Genin.this,StartingScreen.class));
            }
        });
    }
}
