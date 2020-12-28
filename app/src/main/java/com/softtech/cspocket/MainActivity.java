package com.softtech.cspocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void calculator(View view) {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }
    public void word (View viwe){

        Intent intent = new Intent(this, word.class);
        startActivity(intent);
    }

    public void painting(View view) {
        Intent intent = new Intent(this, Paint.class);
        startActivity(intent);
    }
}