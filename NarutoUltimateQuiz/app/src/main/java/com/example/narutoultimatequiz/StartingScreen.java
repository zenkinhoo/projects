package com.example.narutoultimatequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class StartingScreen extends AppCompatActivity {
    Button btnPlay;
    Dialog enterNameDialog;
    ImageButton enterCancel;
    TextView enterName;
    AlertDialog dialog;
    AlertDialog dialog1;
    Button btnQuit;
    Button btnYes;
    Button btnNo;

    Button btnStartQuiz;
    EditText receiveName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        btnPlay = findViewById(R.id.btnPlay);
        btnQuit = findViewById(R.id.btnQuit);
        enterNameDialog = new Dialog(this);




        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StartingScreen.this);
                View view = getLayoutInflater().inflate(R.layout.enter_name,null);
                enterCancel =  (ImageButton)view.findViewById(R.id.enterCancel);
                receiveName = (EditText)view.findViewById(R.id.receiveName);
                btnStartQuiz = (Button)view.findViewById(R.id.btnStartQuiz);
                enterName = (TextView)view. findViewById(R.id.enterName);

                builder.setView(view);
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
                enterCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnStartQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyApplication.setNickname(receiveName.getText().toString());
                        startActivity(new Intent(StartingScreen.this,Question_1.class));
                    }
                });

            }
        });
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(StartingScreen.this);
                View view = getLayoutInflater().inflate(R.layout.quit,null);
                btnYes = (Button)view.findViewById(R.id.btnYes);
                btnNo = (Button)view.findViewById(R.id.btnNo);

                builder1.setView(view);
                builder1.setCancelable(false);
                dialog1 = builder1.create();
                dialog1.show();

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finishAffinity();
                        System.exit(0);
                    }
                });

                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
            }
        });

    }


}
