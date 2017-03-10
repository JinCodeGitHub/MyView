package songzhihao.bwei.com.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者： 宋智豪
 * * 时间： 2017/3/10 09:48
 * * 描述： 五角星
 */

public class Stars extends View{

    private float radius = 20;
    private int color = 0xFF0000 ;
    private final static float DEGREE = 36; //五角星角度

    public Stars(Context context) {
        this(context,null);
    }

    public Stars(Context context, AttributeSet attrs) {
        this(context, attrs,R.style.AppTheme);
        //获取自定义属性
        try {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Stars);
            this.color = a.getColor(R.styleable.Stars_color, color);
            this.radius = a.getFloat(R.styleable.Stars_radius, radius);
            a.recycle();
        } catch (Exception e) {

        }
    }

    public Stars(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 角度转弧度
     * @param degree
     * @return
     */
    private float degree2Radian(float degree){
        return (float) (Math.PI * degree / 180);
    }

    @Override
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams params = super.getLayoutParams();
        try {
            params.width = (int) (radius * Math.cos(degree2Radian(DEGREE) / 2) * 2);
            params.height = (int) (radius + radius * Math.cos(degree2Radian(DEGREE)));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return params;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(this.color);
        paint.setAntiAlias(true);
        //paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        float radian = degree2Radian(DEGREE);
        float radius_in = (float) (radius * Math.sin(radian / 2) / Math.cos(radian)); //中间五边形的半径

        path.moveTo((float) (radius * Math.cos(radian / 2)), 0);
        path.lineTo((float) (radius * Math.cos(radian / 2) + radius_in * Math.sin(radian)), (float) (radius - radius * Math.sin(radian / 2)));
        path.lineTo((float) (radius * Math.cos(radian / 2) * 2), (float) (radius - radius * Math.sin(radian / 2)));
        path.lineTo((float) (radius * Math.cos(radian / 2) + radius_in * Math.cos( radian /2)),(float) (radius + radius_in * Math.sin( radian /2)));
        path.lineTo((float) (radius * Math.cos(radian / 2) + radius * Math.sin(radian)), (float) (radius + radius * Math.cos(radian)));
        path.lineTo((float) (radius * Math.cos(radian / 2)), (float) (radius + radius_in));
        path.lineTo((float) (radius * Math.cos(radian / 2) - radius * Math.sin(radian)), (float) (radius + radius * Math.cos(radian)));
        path.lineTo((float) (radius * Math.cos(radian / 2) - radius_in * Math.cos( radian /2)), (float) (radius + radius_in * Math.sin(radian / 2)));
        path.lineTo(0, (float) (radius - radius * Math.sin(radian /2)));
        path.lineTo((float) (radius * Math.cos(radian / 2) - radius_in * Math.sin(radian)) , (float) (radius - radius * Math.sin(radian /2)));

        path.close();
        canvas.drawPath(path, paint);
        canvas.restore();
        Bitmap bitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        canvas.drawBitmap(bitmap, 10, 10, paint);
    }
}
