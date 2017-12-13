package com.bawie.myview.myview4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.bawie.myview.myview3.BaseView;

/**
 *继承封装的BaseView
 */

public class MyText extends BaseView{

    private Paint paint = new Paint();

    private float rx = 0;

    public MyText(Context context) {
        super(context);
    }

    public MyText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawSub(Canvas canvas) {

        paint.setTextSize(30);
        canvas.drawText("魔道祖师",rx,30,paint);

    }

    @Override
    protected void logic() {

        //屏幕当中滚动
        rx += 3;
        if(rx > getWidth()){
            rx =-paint.measureText("魔道祖师");
        }


    }
}
