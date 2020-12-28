package com.softtech.cspocket;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import static com.softtech.cspocket.painting.*;


public class Paint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

    }

    public void pen(View view) {
        brush.setColor(Color.BLACK);
        getColors(brush.getColor());
    }

    public void eraser(View view) {
        paths.clear();
        colors.clear();
        path.reset();

    }

    public void pink(View view) {
        brush.setColor(getResources().getColor(R.color.pink));
        getColors(brush.getColor());
    }

    public void purble_light(View view) {
        brush.setColor(getResources().getColor(R.color.purple_200));
        getColors(brush.getColor());
    }

    public void purple(View view) {
        brush.setColor(getResources().getColor(R.color.purple_500));
        getColors(brush.getColor());
    }

    public void blue(View view) {
        brush.setColor(Color.BLUE);
        getColors(brush.getColor());
    }

    public void green(View view) {
        brush.setColor(Color.GREEN);
        getColors(brush.getColor());
    }

    public void red(View view) {
        brush.setColor(Color.RED);
        getColors(brush.getColor());
    }

    public void orange(View view) {
        brush.setColor(getResources().getColor(R.color.orange));
        getColors(brush.getColor());
    }

    public void yellow(View view) {
        brush.setColor(Color.YELLOW);
        getColors(brush.getColor());
    }
    public void getColors(int color){
       color =  current_brush;
       path = new Path();
    }
}