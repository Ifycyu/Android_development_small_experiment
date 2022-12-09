package com.jnu.myapplication.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import com.jnu.myapplication.R;

public class Spriter {
    float x,y;
    int drawId;
    double direction;

    Context context;
    public void move(float maxHeight,float maxWidth)//不要到屏幕外
    {
        if(Math.random()<0.05)
        {
            setDirection((float) (Math.random()*2*Math.PI));
        }
        x=(float) (x+30*Math.cos(direction));
        y=(float) (y+30*Math.sin(direction));
        if(x<0) x+=maxWidth;
        if(x>maxWidth) x-=maxWidth;
        if(y<0) y+=maxHeight;
        if(y>maxHeight) y-=maxHeight;
    }
public Spriter(Context context)
{
    this.context = context;
}
    public  void draw(Canvas canvas)//画图
    {
        Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.dishu))
                .getBitmap();
        Rect mSrcRect, mDestRect;
        Paint mBitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mBitPaint.setFilterBitmap(true);
        mBitPaint.setDither(true);
//        mSrcRect = new Rect((int)getX(), (int)getY(), 400, 400);
//        mDestRect = new Rect(0, 0, 400, 400);
        canvas.drawBitmap(bitmap, getX(), getY(), mBitPaint);
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getDrawId() {
        return drawId;
    }

    public void setDrawId(int drawId) {
        this.drawId = drawId;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public boolean isTouched(float touchedX, float touchedY) {
//        Log.i("test",""+((touchedX - x) *(touchedX - x) +(touchedY - y) *(touchedY - y)));
//        return (touchedX - x) *(touchedX - x) +(touchedY - y) *(touchedY - y) <=200000;
                Log.i("test","x"+x+"tx"+touchedX+"y"+y+"ty"+touchedY);

        if((touchedX-453)< x && touchedX >x && (touchedY - 500) <(y+473) && touchedY >(y+473))
        return  true;
    else return false;
    }
}
