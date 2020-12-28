package com.softtech.cspocket;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    TextView edit;
    double input1=0,input2=0;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,
            btnplus,btnmin,btnx,btneq,btnc,btnnspa,btn3la;
    boolean add,multi,min,div,nesp,decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        btn1= findViewById(R.id.btn1);
        btn0=findViewById(R.id.btn0);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btndot=findViewById(R.id.btn_dot);
        btnplus=findViewById(R.id.btn_plus);
        btnmin=findViewById(R.id.btn_min);
        btnx=findViewById(R.id.btn_x);
        btneq=findViewById(R.id.btnequal);
        btnc=findViewById(R.id.c);
        btnnspa=findViewById(R.id.btn_n);
        edit=findViewById(R.id.txtfady);
        btn3la=findViewById(R.id.btn_div);
        final TextView comp = findViewById(R.id.company);
        final MediaPlayer mp =MediaPlayer.create(this, R.raw.click);
        final MediaPlayer mp_2 =MediaPlayer.create(this, R.raw.c);
        final MediaPlayer mp_3 =MediaPlayer.create(this, R.raw.score_beep);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"0");
                mp.start();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"1");
                mp.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"2");
                mp.start();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"3");
                mp.start();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"4");
                mp.start();

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"5");
                mp.start();

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"6");
                mp.start();

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"7");
                mp.start();

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"8");
                mp.start();

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"9");
                mp.start();

            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+".");
                mp.start();

            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if (edit.getText().length() !=0){
                    input1 =Float.parseFloat(edit.getText()+"");
                    add=true;
                    decimal=false;
                    edit.setText(null);
                }
            }
        });
        btnmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if(edit.getText().length() !=0){
                    input1 =Float.parseFloat(edit.getText()+"");
                    min=true;
                    decimal=false;
                    edit.setText(null);
                }
            }
        });
        btn3la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if(edit.getText().length() !=0){
                    input1 =Float.parseFloat(edit.getText()+"");
                    div=true;
                    decimal=false;
                    edit.setText(null);
                }
            }
        });
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if(edit.getText().length() !=0){
                    input1 =Float.parseFloat(edit.getText()+"");
                    multi=true;
                    decimal=false;
                    edit.setText(null);
                }
            }
        });
        btnnspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                // edit.setText(edit.getText()+"%");
                if(edit.getText().length() !=0){
                    input1 =Float.parseFloat(edit.getText()+"");
                    nesp=true;
                    decimal=false;
                    edit.setText(null);
                }
            }
        });
        btneq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // edit.setText(edit.getText()+"=");
                if (add||min ||div || multi || nesp){
                    input2=Float.parseFloat(edit.getText()+"");
                    mp_3.start();
                }
                if (add){
                    edit.setText(input1+input2+"");
                    add=false;
                }
                if (min){
                    edit.setText(input1-input2+"");
                    min=false;
                }
                if (div){
                    edit.setText(input1/input2+"");
                    if ( (input1/input2)+ ""== (1972001.0)+"") {
                        comp.setText("Abdalrhman Mostafa");
                        comp.getVisibility();
                    }
                    div=false;

                }
                if (multi){
                    edit.setText(input1*input2+"");
                    multi=false;
                }
                if (nesp){
                    edit.setText(input1%input2+"");
                    nesp=false;
                }
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("");
                mp_2.start();
            }
        });
        if(edit.getText() == 2001 + ""){
            comp.setText("Abdalrhman Mostafa");
        }
    }
}