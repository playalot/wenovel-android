package szu.whale.wenote.widget.actiontoolbar;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/28 0028.
 * version :1.0.
 */
public class ActionBar extends View {

    private String picName;
    private String picUrl;
    private int count;

    public ActionBar(Context context) {
        super(context);

    }

    public ActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
