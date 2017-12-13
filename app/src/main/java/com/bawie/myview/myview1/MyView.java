package com.bawie.myview.myview1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bawie.myview.R;

/**
 * 自定义view
 */

public class MyView extends View {

    private Bitmap bitmap;


    public MyView(Context context) {
        super(context);
        //赋值图片
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //赋值图片
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制元素
        //实例化
        Paint paint = new Paint();//影响绘制文字
         paint.setTextSize(30);
         //颜色
       // paint.setColor(Color.YELLOW);
        canvas.drawText("一切美好的事情~",0,30,paint);

        //绘制直线
        canvas.drawLine(0,60,100,60,paint);

        //绘制矩形方法1
        canvas.drawRect(20,90,120,190,paint);

        //绘制矩形方法2
        //都是int类型
        Rect r = new Rect(10,200,110,300);
        canvas.drawRect(r,paint);

        //绘制矩形方法3
        //都是float类型
        RectF f = new RectF(120,200,220,300);
        canvas.drawRect(f,paint);

        //圆角矩形的绘制
        RectF f2 = new RectF(120,310,220,410);
        canvas.drawRoundRect(f2,30,30,paint);

        //绘制圆形
        canvas.drawCircle(60,360,50,paint);

        //绘制图片
        canvas.drawBitmap(bitmap,150,100,paint);


    }
}
