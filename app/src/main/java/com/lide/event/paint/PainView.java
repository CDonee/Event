package com.lide.event.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author djc
 * @time 2018/3/21  9:29
 * @desc ${TODD}
 */
public class PainView extends View {
    private Paint mPaint;

    public PainView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //重置
        mPaint.reset();
        mPaint.setColor(Color.RED);
        mPaint.setAlpha(225);

        //设置画笔的样式
        //     mPaint.setStyle(Paint.Style.FILL); //填充
        //     mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //        mPaint.setStyle(Paint.Style.STROKE);//描边
        //
        mPaint.setStrokeWidth(1); //设置画笔的宽度
        //
        //        //线帽
        //        mPaint.setStrokeCap(Paint.Cap.BUTT); //no
        // mPaint.setStrokeCap(Paint.Cap.ROUND);//圆形
        //  mPaint.setStrokeCap(Paint.Cap.SQUARE);//方形

        //线条交汇
        //        mPaint.setStrokeJoin(Paint.Join.MITER); //锐角
        //        mPaint.setStrokeJoin(Paint.Join.BEVEL);  //直线
        //        mPaint.setStrokeJoin(Paint.Join.ROUND);  //圆角
        //
        //        canvas.drawCircle(100,100,100,mPaint);

        //        //防锯齿 对锯齿模糊处理 损失一定的性能
        //        mPaint.setAntiAlias(true);
        //        //防抖动 有磨平的效果
        //        mPaint.setDither(true);
        //
        //
        //        //t1
        //        Path path = new Path();
        //        path.moveTo(100,100);
        //        path.lineTo(300,100);
        //        path.lineTo(100,300);
        //        mPaint.setStrokeJoin(Paint.Join.MITER);
        //        canvas.drawPath(path,mPaint);
        //        //t2
        //        path.moveTo(100,400);
        //        path.lineTo(300,500);
        //        path.lineTo(100,700);
        //        mPaint.setStrokeJoin(Paint.Join.ROUND);
        //        canvas.drawPath(path,mPaint);
        //        //t3
        //        path.moveTo(100,800);
        //        path.lineTo(300,800);
        //        path.lineTo(100,1100);
        //        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        //        canvas.drawPath(path,mPaint);
        //
        //        //=====文字绘制=======
        //        mPaint.getFontSpacing();  //文字间距
        //        mPaint.getLetterSpacing();  //字符间距
        //        mPaint.setStrikeThruText(true);  //删除线
        //        mPaint.setUnderlineText(true);   //下划线
        //        mPaint.setTextSize(22);
        //        mPaint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        //
        //        //文字倾斜默认0  官方推荐-0.25为斜体
        //        mPaint.setTextSkewX(-0.25f);
        //
        //        //设置文字对齐方式
        //        mPaint.setTextAlign(Paint.Align.CENTER);
        //        mPaint.setTextAlign(Paint.Align.LEFT);
        //        mPaint.setTextAlign(Paint.Align.RIGHT);
        //
        //计算指定长度的字符串,(字符长度,字符个数,显示的时候的真实长度)
        // mPaint.breakText();
        String str = "你好11!";
        //=======================
        mPaint.setTextSize(50);
        float[] measuredWidth = new float[5];
        int breakText = mPaint.breakText(str, true, 300, measuredWidth);  //获得字符个数
        float measureText = mPaint.measureText(str); //获得文字总宽度
        int mPaintTextWidths = mPaint.getTextWidths(str, measuredWidth);
        Log.d("test", "breakText = " + breakText + "  str.length() = " + str.length() + "  measureText ="
                + measureText + " mPaintTextWidths = " + mPaintTextWidths);
        //数值正负相对于基线而言的
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float top = fontMetrics.top;
        float ascent = fontMetrics.ascent;
        float descent = fontMetrics.descent;
        float bottom = fontMetrics.bottom;
        Log.d("test", "top=" + top + " as=" + ascent + " ds=" + descent + " bo=" + bottom);
        canvas.drawText(str, 0, 50, mPaint);
    }
}
