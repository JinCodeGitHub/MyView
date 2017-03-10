package songzhihao.bwei.com.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者： 宋智豪
 * * 时间： 2017/3/10 15:15
 * * 描述： 尚未编写描述
 */

public class SimStar extends View{
    public SimStar(Context context) {
        this(context,null);
    }

    public SimStar(Context context, AttributeSet attrs) {
        this(context, attrs,R.style.AppTheme);
    }

    public SimStar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final Paint paint = new Paint();
        Path path = new Path();
        paint.setColor(Color.RED);
        path.moveTo(0,100);
        path.lineTo(250,300);
        path.lineTo(150,0);
        path.lineTo(50,300);
        path.lineTo(300,100);
        path.lineTo(0,100);
        canvas.drawPath(path,paint);

    }
}
