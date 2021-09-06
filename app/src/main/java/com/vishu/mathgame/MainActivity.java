package com.vishu.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addition;
    Button subtraction;
    Button multiply;
    Button division;
    int option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition=findViewById(R.id.buttonadd);
        subtraction=findViewById(R.id.buttonsub);
        multiply=findViewById(R.id.buttonmul);
        division=findViewById(R.id.buttondiv);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,game.class);
                intent.putExtra("option",1);
                startActivity(intent);
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,game.class);
                intent.putExtra("option",2);
                startActivity(intent);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,game.class);
                intent.putExtra("option",3);
                startActivity(intent);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,game.class);
                intent.putExtra("option",4);
                startActivity(intent);
            }
        });
    }
}