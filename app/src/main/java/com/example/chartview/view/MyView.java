package com.example.chartview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.chartview.R;

/**
 * 时间：2017/9/25
 * 作者：黄伟才
 * 描述：
 */

public class MyView extends View {
    /**
     * 中央分割线的绘制
     **/
    private Paint linePaint;
    private Paint strockpaint;
    private Paint p;
    private Bitmap decodeResource;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
//      linePaint.setColor(Color.parseColor("#aeaeae"));
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(2f);
        linePaint.setTextSize(25);
        linePaint.setStrokeJoin(Paint.Join.ROUND);


        strockpaint = new Paint();
        strockpaint.setAntiAlias(true);
        strockpaint.setStyle(Paint.Style.STROKE);
        strockpaint.setColor(Color.BLUE);
        DashPathEffect effects = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);
        strockpaint.setPathEffect(effects);

        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        p.setStrokeWidth(1);
        p.setTextSize(30);
        p.setStrokeWidth(10);

        DashPathEffect effects1 = new DashPathEffect(new float[]{1, 4, 7, 8}, 1);
        p.setPathEffect(effects1);
        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.exchange_icon);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(100, 0, 600, 1000, linePaint);

        canvas.drawCircle(202, 202, 100, strockpaint);
        canvas.drawLine(0, 0, 400, 400, strockpaint);
        canvas.drawRect(20, 100, 21, 450, strockpaint);


        canvas.drawText("绘制红色的虚线", 210, 300, linePaint);
        canvas.drawLine(200, 140, 500, 40, p);
        //绘制红色的虚线
        Path path = new Path();
        path.moveTo(200, 300);
        path.lineTo(300, 1600);
        canvas.drawPath(path, p);
        canvas.drawBitmap(createRepeaterY(1000, decodeResource), 300, 300, null);
    }

    //绘制重复bitmap的图片
    public Bitmap createRepeaterY(int height, Bitmap src) {
        int count = (height + src.getHeight() - 1) / src.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(src.getWidth(), height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        for (int idx = 0; idx < count; ++idx) {
            canvas.drawBitmap(src, 0, idx * src.getHeight(), null);
        }
        return bitmap;
    }

}
