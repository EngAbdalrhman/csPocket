package com.softtech.cspocket;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class painting extends View {
    static ArrayList<Path> paths = new ArrayList<>();
    static ArrayList<Integer> colors = new ArrayList<>();

    LayoutParams params ;
    static Path path = new Path();
    static Paint brush = new Paint();
    static int current_brush = Color.BLACK;
    public painting(Context context) {
        super(context);
        paints();
    }

    public painting(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paints();
    }

    public painting(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paints();
    }

    public painting(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        paints();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction())
        {
            case  MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                invalidate();
                return true;
            case  MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                paths.add(path);
                colors.add(current_brush);
                invalidate();
                return true;
            default:
                return false;
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0 ; i < paths.size(); i++)
        {
            brush.setColor(colors.get(i));
            canvas.drawPath(paths.get(i),brush);
            invalidate();

        }
    }
    void paints(){
        brush.setAntiAlias(true);
        brush.setColor(Color.BLACK);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(8f);

        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }
}
