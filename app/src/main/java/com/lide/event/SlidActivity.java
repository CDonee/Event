package com.lide.event;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.lide.event.defineView.SlidingMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author DaiJiCheng
 * @time 2018/3/20  10:48
 * @desc ${TODD}
 */
public class SlidActivity extends Activity {
    @BindView(R.id.one)
    ImageView mOne;
    @BindView(R.id.two)
    ImageView mTwo;
    @BindView(R.id.three)
    ImageView mThree;
    @BindView(R.id.four)
    ImageView mFour;
    @BindView(R.id.five)
    ImageView mFive;
    @BindView(R.id.id_menu)
    SlidingMenu mIdMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View mView = LayoutInflater.from(this).inflate(R.layout.main, null);
        mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

    }

    @OnClick({R.id.one, R.id.two, R.id.three, R.id.four, R.id.five})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one:
                showToast("one");
                break;
            case R.id.two:
                showToast("two");
                break;
            case R.id.three:
                showToast("three");
                break;
            case R.id.four:
                showToast("four");
                break;
            case R.id.five:
                showToast("five");
                break;
        }
    }

    public  void  showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
