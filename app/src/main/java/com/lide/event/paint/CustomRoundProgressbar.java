package com.lide.event.paint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lide.event.R;

/**
 * @author DaiJiCheng
 * @time 2018/3/22  13:54
 * @desc ${TODD}
 */
public class CustomRoundProgressbar extends View {

    private Paint mPaint;
    private boolean mTextShow;
    private int mRoundProgressColor;
    private int mTextColor;
    private int mRoundColor;
    private int mTextSize;
    private int mProgerss_max;
    private int mRounWidth;
    private int mProgressStyle;
    public static int STROKE = 0;
    public static int FILL = 1;
    private int mProgerss;

    public boolean isTextShow() {
        return mTextShow;
    }

    public void setTextShow(boolean textShow) {
        mTextShow = textShow;
    }

    public int getRoundProgressColor() {
        return mRoundProgressColor;
    }

    public void setRoundProgressColor(int roundProgressColor) {
        mRoundProgressColor = roundProgressColor;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    public int getRoundColor() {
        return mRoundColor;
    }

    public void setRoundColor(int roundColor) {
        mRoundColor = roundColor;
    }

    public int getTextSize() {
        return mTextSize;
    }

    public void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    public int getProgerss_max() {
        return mProgerss_max;
    }

    public synchronized void setProgerss_max(int progerss_max) {
        if (progerss_max < 0) {
            throw new IllegalArgumentException("最大进度不能小于0");
        }
        mProgerss_max = progerss_max;
    }

    public int getRounWidth() {
        return mRounWidth;
    }

    public void setRounWidth(int rounWidth) {
        mRounWidth = rounWidth;
    }

    public int getProgressStyle() {
        return mProgressStyle;
    }

    public void setProgressStyle(int progressStyle) {

        mProgressStyle = progressStyle;
    }

    public int getProgerss() {

        return mProgerss;
    }

    public synchronized void setProgerss(int progerss) {
        if (progerss < 0) {
            throw new IllegalArgumentException("progress不能小于0");
        }
        if (progerss > mProgerss_max) {
            mProgerss = mProgerss_max;
        }
        if (progerss <= mProgerss_max) {
            this.mProgerss = progerss;
            postInvalidate();
        }
    }

    public CustomRoundProgressbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRoundProgressbar);
        mTextShow = typedArray.getBoolean(R.styleable.CustomRoundProgressbar_textShow, true);
        mRoundProgressColor = typedArray.getColor(R.styleable.CustomRoundProgressbar_roundProgressColor, Color.BLUE);
        mRoundColor = typedArray.getColor(R.styleable.CustomRoundProgressbar_roundColor, Color.BLACK);
        mTextColor = typedArray.getColor(R.styleable.CustomRoundProgressbar_textColor, Color.RED);
        mTextSize = typedArray.getColor(R.styleable.CustomRoundProgressbar_textSize, 22);
        mProgerss_max = typedArray.getColor(R.styleable.CustomRoundProgressbar_max, 100);
        mProgerss = typedArray.getColor(R.styleable.CustomRoundProgressbar_progress, 0);
        mRounWidth = typedArray.getColor(R.styleable.CustomRoundProgressbar_roundWidth, 5);
        mProgressStyle = typedArray.getColor(R.styleable.CustomRoundProgressbar_style, 0);
        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
