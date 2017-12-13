package com.bawie.myview.myview3;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * 自定义view 的封装
 */

public abstract class BaseView extends View {

    //随机数
    Random random = new Random();
    private MyThead thead;


    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //绘制方面的代码
    protected abstract void drawSub(Canvas canvas);
    //逻辑方面的代码
    protected abstract void logic();

    //用final修饰父类的方法，子类是不可以修改
    @Override
    protected final void onDraw(Canvas canvas) {

        //判空处理  实例化
        if(thead == null){
            thead = new MyThead();
            thead.start();
        }else{
            //绘制方法
            drawSub(canvas);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        //当离开屏幕后，结束文字的循环
        running = false;
        super.onDetachedFromWindow();
    }

    private boolean running = true;
    class MyThead extends Thread{

        @Override
        public void run() {

            //循环很快，会看不见文字，需要线程睡眠
            //文字循环慢，可以调节睡眠时间和坐标，
            // 但是不建议调节睡眠时间，对性能有影响
            while (running){
                logic();//逻辑方法
                // postInvalidate();这个是重新调用onDraw方法
                postInvalidate();
                //睡眠
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
