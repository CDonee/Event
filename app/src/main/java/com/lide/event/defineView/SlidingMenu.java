package com.lide.event.defineView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;

/**
 * @author DaiJiCheng`
 * @time 2018/3/20  9:46
 * @desc ${TODD}
 */
public class SlidingMenu extends HorizontalScrollView {

    private int mScreenWith;
    private ViewGroup mMenu;
    private ViewGroup mMain;
    private int mPadding;
    private boolean hasLayout;
    private int mMenuWith;
    private float mDownX;
    private int mMTouchSlop;

    public SlidingMenu(Context context) {
        super(context);
        initv(context);
    }


    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initv(context);
    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initv(context);
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     */
    private void initv(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        mScreenWith = outMetrics.widthPixels;

      //  final ViewConfiguration configuration = ViewConfiguration.get(context);
        //系统允许的滑动的最小距离    ;//作为判断点击还是滑动事件的最小距离
     //   mMTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
         mMTouchSlop = ViewConfiguration.getTouchSlop();
        mPadding = 120; //屏幕1/4的间距
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!hasLayout) {
            LinearLayout wrapper = (LinearLayout) getChildAt(0); //SlidingMenu作为viewgroup获取到自身的第一个view
            mMenu = (ViewGroup) wrapper.getChildAt(0);
            mMain = (ViewGroup) wrapper.getChildAt(1);

            mMenuWith = mScreenWith - mPadding;
            mMenu.getLayoutParams().width = mMenuWith;
            mMain.getLayoutParams().width = mScreenWith;                    //给子view设置固定的宽高
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        if (changed) {
            hasLayout = true;
        }
        this.scrollTo(mMenuWith, 0);  //设置初始滑动位置
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDownX = ev.getX();
                break;
            case MotionEvent.ACTION_HOVER_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                float diffX = ev.getX() - mDownX;
                if (diffX < -mMTouchSlop) {
                    this.smoothScrollTo(mMenuWith, 0);
                } else if (diffX > mMTouchSlop) {
                    this.smoothScrollTo(0, 0);
                } else {
                    return false;  //响应子控件的点击事件
                }
                return true;  //消费此事件

        }
        return super.onTouchEvent(ev);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        float factor = (float) l / mMenuWith;
        ViewHelper.setTranslationX(mMenu, mMenuWith * factor * 0.6f);
        //2.缩放效果
        float leftScale = 1 - 0.4f * factor;
        ViewHelper.setScaleX(mMenu, leftScale);
        ViewHelper.setScaleY(mMenu, leftScale);

        float rightScale = 0.8f + 0.2f * factor;
        ViewHelper.setScaleX(mMain, rightScale);
        ViewHelper.setScaleY(mMain, rightScale);
        //3.透明度效果
        ViewHelper.setAlpha(mMenu, 1 - factor);

    }
}
