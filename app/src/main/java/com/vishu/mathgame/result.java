package com.vishu.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView result;
    Button playAgain;
    Button exit;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result=findViewById(R.id.textViewresult);
        playAgain=findViewById(R.id.buttonplayagain);
        exit=findViewById(R.id.buttonexit);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0);
        result.setText("Your Score is "+score);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(result.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}