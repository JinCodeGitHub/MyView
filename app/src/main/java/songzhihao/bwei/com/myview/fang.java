package songzhihao.bwei.com.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者： 宋智豪
 * * 时间： 2017/3/9 13:34
 * * 描述： 尚未编写描述
 */

public class fang extends View{
    public fang(Context context) {
        this(context,null);
    }

    public fang(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public fang(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mpaint = new Paint();
        mpaint.setColor(Color.RED);
        mpaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(160, 160, 180, 180, mpaint);// 正方形

    }
}
