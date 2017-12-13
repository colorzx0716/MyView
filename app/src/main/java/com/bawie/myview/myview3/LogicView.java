package com.bawie.myview.myview3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by 张肖肖 on 2017/12/13.
 */

public class LogicView extends BaseView {

    private Paint paint = new Paint();
    private float rx = 0;
    //圆形的大小
    private RectF f = new RectF(0,60,100,160);

    private float sweepAngle = 0;

    public LogicView(Context context) {
        super(context);
    }

    public LogicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        //文字
        paint.setTextSize(25);
        canvas.drawText("我是弹幕1~",rx,30,paint);
        //圆形
        //oval=圆的大小 startAngle=起始的角度  sweepAngle=区间的角度 userCenter=true/false paint
        //true--是从半径一边开始画圆
        //false--是从一点，像月亮的盈亏一样画圆
        canvas.drawArc(f,0,sweepAngle,true,paint);
    }

    @Override
    protected void logic() {

        rx = rx +3;

        if(rx > getWidth()){
            //测量文字的长度，让文字一点点的从左边显示出来
            rx = 0-paint.measureText("这是一条闪烁的弹幕");

        }
        sweepAngle++;//每次加一个角度
        if(sweepAngle > 360){
            sweepAngle = 0;
        }
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        paint.setARGB(255,r,g,b);

    }
}
