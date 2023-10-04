package com.yusufsenturk.timerforchessplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView player1Time;
    TextView player2Time;
    TextView tiklandiPlayer1;
    TextView tiklandiPlayer2;

    Runnable runnable;
    Handler handler;

    int Time;
    int adTime;
    int p1Time;
    int p2Time;
    int p1Saniye;
    int p2Saniye;

    boolean p1=true;
    boolean p2=false;
    boolean uygbas=true;

    Intent intent;
    Intent intent2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Time=findViewById(R.id.player1Time);
        player2Time=findViewById(R.id.player2Time);
        tiklandiPlayer2=findViewById(R.id.tiklandiPlayer2);
        tiklandiPlayer1=findViewById(R.id.tiklandiPlayer1);

        intent2=new Intent(getApplicationContext(),MainActivity2.class);
        intent=getIntent();
        Time=intent.getIntExtra("Time",0);
        adTime=intent.getIntExtra("Add",0);

        p1Time=Time;
        p2Time=Time;
        p1Saniye=1;
        p2Saniye=1;

        handler=new Handler();

        runnable=new Runnable() {
            @Override
            public void run() {


                if(p1){
                    p1Saniye--;
                    if(p1Saniye>=0 ){
                        if(p1Saniye<10){
                            if(p1Time<10){
                                player1Time.setText("0"+p1Time+"."+"0"+p1Saniye);
                            }
                            else{
                                player1Time.setText(p1Time+"."+"0"+p1Saniye);
                            }

                        }
                        else{
                            if(p1Time<10){
                                player1Time.setText("0"+p1Time+"."+p1Saniye);
                            }
                            else{
                                player1Time.setText(p1Time+"."+p1Saniye);
                            }

                        }

                    }
                    else{
                        p1Time--;
                        p1Saniye=59;
                        if(p1Time<10){
                            player1Time.setText("0"+p1Time+"."+p1Saniye);
                        }
                        else{
                            player1Time.setText(p1Time+"."+p1Saniye);
                        }

                    }
                    if(uygbas){
                        player2Time.setText(Time+"."+p2Saniye+"0");
                        player1Time.setText(Time+"."+p1Saniye+"0");
                        uygbas=false;
                    }


                }
                if(p2){
                    p2Saniye--;
                    if(p2Saniye>=0 ){
                        if(p2Saniye<10){
                            if(p2Time<10){
                                player2Time.setText("0"+p2Time+"."+"0"+p2Saniye);
                            }
                            else{
                                player2Time.setText(p2Time+"."+"0"+p2Saniye);
                            }

                        }
                        else{
                            if(p2Time<10){
                                player2Time.setText("0"+p2Time+"."+p2Saniye);
                            }
                            else{
                                player2Time.setText(p2Time+"."+p2Saniye);
                            }

                        }

                    }
                    else {
                        p2Time--;
                        p2Saniye = 59;
                        if (p2Time < 10) {
                            player2Time.setText("0" + p2Time + "." + p2Saniye);
                        } else {
                            player2Time.setText(p2Time + "." + p2Saniye);
                        }

                    }
                }
                handler.postDelayed(runnable,1000);
                if(p1Time==0 && p1Saniye==0){
                    bitirp1();
                }
                if(p2Time==0 && p2Saniye==0){
                    bitirb2();

                }
            }
        };
        handler.post(runnable);



    }

    public void tiklaP1(View view){
        p1Saniye+=adTime;
        if(p1Saniye>59){
            p1Time++;
            p1Saniye=p1Saniye-60;
            if(p1Time<10){
                player1Time.setText("0"+p1Time+"."+"0"+p1Saniye);
            }
            else{
                player1Time.setText(p1Time+"."+"0"+p1Saniye);
            }
        }
        else{
            if(p1Time<10){
                player1Time.setText("0"+p1Time+"."+p1Saniye);
            }
            else{
                player1Time.setText(p1Time+"."+p1Saniye);
            }
        }
        p1=false;
        p2=true;

    }
    public void tiklaP2(View view){
        p2Saniye+=adTime;
        if(p2Saniye>59){
            p2Time++;
            p2Saniye=p2Saniye-60;
            if(p2Time<10){
                player2Time.setText("0"+p2Time+"."+"0"+p2Saniye);
            }
            else{
                player2Time.setText(p2Time+"."+"0"+p2Saniye);
            }
        }
        else{
            if(p2Time<10){
                player2Time.setText("0"+p2Time+"."+p2Saniye);
            }
            else{
                player2Time.setText(p2Time+"."+p2Saniye);
            }
        }
        p2=false;
        p1=true;
    }
    public void Home(View view){

        startActivity(intent2);
    }
    public void bitirp1(){
        handler.removeCallbacks(runnable);
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Player 1 WON");
        builder.setMessage("Press yes to HOME");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(intent2);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
            }
        });
        builder.show();
    }
    public void bitirb2(){
        handler.removeCallbacks(runnable);
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Player 2 WON");
        builder.setMessage("Press yes to HOME");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(intent2);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
            }
        });
        builder.show();
    }

}