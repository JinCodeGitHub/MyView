package songzhihao.bwei.com.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者： 宋智豪
 * * 时间： 2017/3/10 14:17
 * * 描述： 尚未编写描述
 */

public class StarView extends View{

    private float radius = 100;
    private Paint mPaint;
    private Point cPoint;//圆心

    //五角星的五个角
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point p5;

    public StarView(Context context) {
        this(context,null);
    }

    public StarView(Context context, AttributeSet attrs) {
        this(context, attrs,R.style.AppTheme);
    }

    public StarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //拿到数据
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.Stars);
        radius = array.getFloat(R.styleable.Stars_radius, 100);
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        circle(canvas);
        makep5();
        drawStar(canvas);
    }

    private void drawStar(Canvas canvas) {
        canvas.drawLine(p1.x,p1.y,p4.x,p4.y,mPaint);
        canvas.drawLine(p1.x,p1.y,p5.x,p5.y,mPaint);

        canvas.drawLine(p2.x,p2.y,p3.x,p3.y,mPaint);
        canvas.drawLine(p2.x,p2.y,p5.x,p5.y,mPaint);

        canvas.drawLine(p4.x,p4.y,p3.x,p3.y,mPaint);

    }

    private void makep5() {
        //上面的坐标
        p1 = new Point();
        p1.x = cPoint.x;
        p1.y = cPoint.y-radius;
        //url  http://jingyan.baidu.com/article/e4d08ffda964730fd2f60dbd.html
        //计算CF的长度
        double gen5 = Math.sqrt(5);
        double du36 = Math.toRadians(36);
        float cf = (float) Math.sqrt((gen5-1)*radius*0.5*(gen5-1)*radius*0.5+radius*radius);
        float cfy = (float) (cf*Math.sin(du36));
        float cfx = (float) (cf*Math.cos(du36));
        //左上面的坐标
        p2 = new Point();
        p2.x = p1.x-cfx;
        p2.y = p1.y+cfy;
        //右上面的坐标
        p3 = new Point();
        p3.x = p1.x+cfx;
        p3.y = p1.y+cfy;
        //计算CM的长度
        double du18 = Math.toRadians(18);
        double cm = 2*radius*Math.cos(du18);
        float cmy = (float)(cm*Math.cos(du18));
        float cmx = (float)(cm*Math.sin(du18));
        //左下面的坐标
        p4 = new Point();
        p4.x = p1.x-cmx;
        p4.y = p1.y+cmy;
        //右下面的坐标
        p5 = new Point();
        p5.x = p1.x+cmx;
        p5.y = p1.y+cmy;
    }

    private void circle(Canvas canvas) {
        cPoint = new Point();
        //确定中心
        cPoint.x = getWidth()/2;
        cPoint.y = getHeight()/2;
        //画笔的颜色
        mPaint.setColor(Color.RED);
        //画圆
        canvas.drawCircle(cPoint.x,cPoint.y,radius,mPaint);
    }
}
