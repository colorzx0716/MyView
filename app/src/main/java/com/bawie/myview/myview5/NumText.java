package com.bawie.myview.myview5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.bawie.myview.R;
import com.bawie.myview.myview3.BaseView;

/**
 * 在xml里面定义样式属性，在代码中解析使用
 * 自定义View基础和原理
 * 在xml中定义样式和属性并对显示的效果进行影响
 *
 */

public class NumText extends BaseView {

    private Paint paint = new Paint();
    private int lineNum = 0;
    private int mx = 0;

    private boolean xScroll = false;

    public NumText(Context context) {
        super(context);

    }

    public NumText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //在代码中解析
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.NumText);

        lineNum = ta.getInt(R.styleable.NumText_lineNum,1);//参数2是默认值
        xScroll = ta.getBoolean(R.styleable.NumText_xScroll, false);

        ta.recycle();
    }

    @Override
    protected void drawSub(Canvas canvas) {

        for (int i = 0; i < lineNum; i++) {
            int textSize = 30 + i;
            paint.setTextSize(textSize);
            canvas.drawText("魏无羡和蓝忘机这对cp",mx,textSize+textSize*i,paint);
        }

    }

    @Override
    protected void logic() {

        if(xScroll) {
            mx += 3;
            if (mx > getWidth()) {
                mx = (int) -paint.measureText("魏无羡和蓝忘机这对cp");
            }
        }

    }
}
