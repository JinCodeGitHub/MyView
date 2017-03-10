package songzhihao.bwei.com.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者： 宋智豪
 * * 时间： 2017/3/9 14:06
 * * 描述： 尚未编写描述
 */

public class Circle extends View{
    public Circle(Context context) {
        this(context,null);
    }

    public Circle(Context context, AttributeSet attrs) {
        this(context, attrs,R.style.AppTheme);
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mpaint = new Paint();
        mpaint.setColor(Color.RED);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(5);
        mpaint.setAntiAlias(true);
        canvas.drawCircle(getWidth()/2,getHeight()/2,150,mpaint);

        // 绘制这个三角形,你可以绘制任意多边形
        Path path = new Path();
        path.moveTo(getWidth()/2, (getHeight()/2)-150);//此点为多边形的起点
        path.lineTo((getWidth()/2-130), ((getHeight()/2)+(150/2)));//左边的线
        path.lineTo((getWidth()/2)+130, ((getHeight()/2)+(150/2)));//右边的线
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, mpaint);

        canvas.drawCircle(getWidth()/2,getHeight()/2,75,mpaint);



        float v = (float) (Math.sqrt(2) / 2 * 75);
        Path mpath = new Path();
        mpath.moveTo(getWidth()/2+v,getHeight()/2+v);
        mpath.lineTo(getWidth()/2-v,getHeight()/2+v);
        mpath.lineTo(getWidth()/2-v,getHeight()/2-v);
        mpath.lineTo(getWidth()/2+v,getHeight()/2-v);
        mpath.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(mpath, mpaint);

    }
}
