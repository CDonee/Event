package com.lide.event.xuanRan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lide.event.R;

/**
 * @author DaiJiCheng
 * @time 2018/3/30  10:16
 * @desc ${TODD}
 */
public class HandlePicView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;

    public HandlePicView(Context context) {
        super(context);
        vinit();
    }


    public HandlePicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        vinit();
    }
    private void vinit() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.picgao);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint.setMaskFilter(new BlurMaskFilter(20,BlurMaskFilter.Blur.NORMAL));
       //   mPaint.setMaskFilter(new BlurMaskFilter(30,BlurMaskFilter.Blur.INNER));
      //  mPaint.setMaskFilter(new BlurMaskFilter(30,BlurMaskFilter.Blur.OUTER));
       // mPaint.setMaskFilter(new BlurMaskFilter(30,BlurMaskFilter.Blur.SOLID));
        RectF rectF =new RectF(100, 100, 500, 500*mBitmap.getHeight()/mBitmap.getWidth());
        canvas.drawBitmap(mBitmap,null,rectF,mPaint);

    }
}
