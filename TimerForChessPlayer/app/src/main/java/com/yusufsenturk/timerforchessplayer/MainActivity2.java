package com.yusufsenturk.timerforchessplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent=new Intent(getApplicationContext(),MainActivity.class);

    }
    public void game30(View view){

        intent.putExtra("Time",3);
        intent.putExtra("Add",0);
        startActivity(intent);
    }
    public void game32(View view){
        intent.putExtra("Time",3);
        intent.putExtra("Add",2);
        startActivity(intent);
    }
    public void game50(View view){
        intent.putExtra("Time",5);
        intent.putExtra("Add",0);
        startActivity(intent);

    }
    public void game55(View view){
        intent.putExtra("Time",5);
        intent.putExtra("Add",5);
        startActivity(intent);

    }
    public void game100(View view){
        intent.putExtra("Time",10);
        intent.putExtra("Add",0);
        startActivity(intent);

    }
    public void game1510(View view){
        intent.putExtra("Time",15);
        intent.putExtra("Add",10);
        startActivity(intent);

    }
    public void dk1(View view){
        intent.putExtra("Time",1);
        intent.putExtra("Add",0);
        startActivity(intent);

    }
}