 package com.vishu.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

 public class game extends AppCompatActivity {
   TextView score;
   TextView life;
   TextView time;
   TextView question;
   EditText answer;
   Button ok;
   Button next;
   Random random=new Random();
   int number1,number2;
   int userAnswer;
   int realAnswer;
   int userScore=0;
   int userLife=3;

   CountDownTimer timer;
   private static final long START_TIMER_IN_MILTS=60000;
   Boolean timer_running;
   long time_left_in_millis=START_TIMER_IN_MILTS;
   int option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        score=findViewById(R.id.textViewscore);
        life=findViewById(R.id.textViewlife);
        time=findViewById(R.id.textViewtime);
        question=findViewById(R.id.textViewquestion);
        answer=findViewById(R.id.editTextTextAnswer);
        ok=findViewById(R.id.ok);
        next=findViewById(R.id.buttonNext);
        Intent intent=getIntent();
        option=intent.getIntExtra("option",1);
        gameContinue();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userAnswer=Integer.valueOf(answer.getText().toString());
                pauseTimer();
                if(userAnswer==realAnswer)
                {
                    userScore=userScore+10;
                    score.setText(""+userScore);
                    question.setText("Congratulations,Your Answer is Right.");
                }
                else
                {
                    userLife--;
                    life.setText(""+userLife);
                    question.setText("Sorry,Your Answer is Wrong.");
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText("");
                resetTimer();

                if(userLife==0)
                {
                    Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(game.this,result.class);
                    intent.putExtra("score",userScore);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    gameContinue();
                }

            }


        });
    }
    public void gameContinue(){
        number1=random.nextInt(1000);
        number2=random.nextInt(1000);
        if(option==1)
        {
            realAnswer=number1+number2;
            question.setText(number1+" + "+number2);
        }
        else if(option==2)
        {
            realAnswer=number1-number2;
            question.setText(number1+" - "+number2);
        }
        else if(option==3)
        {
            realAnswer=number1*number2;
            question.setText(number1+" * "+number2);
        }
        else
        {
            realAnswer=number1/number2;
            question.setText(number1+" / "+number2);
        }

        startTimer();

    }
    public void startTimer(){
        timer=new CountDownTimer(time_left_in_millis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left_in_millis=millisUntilFinished;
                updateText();
            }

            @Override
            public void onFinish() {
                timer_running=false;
                pauseTimer();
                resetTimer();
                updateText();
                userLife--;
                question.setText("Sorry!Time is Up!");
            }
        }.start();
        timer_running=true;
    }
    public void updateText()
    {
        int second=(int)(time_left_in_millis/1000)%60;
        String time_left=String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }
    public void pauseTimer()
    {
        timer.cancel();
        timer_running=false;
    }
    public void resetTimer()
    {
        time_left_in_millis=START_TIMER_IN_MILTS;
        updateText();
    }

}