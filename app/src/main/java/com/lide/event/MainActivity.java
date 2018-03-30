package com.lide.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_click)
    Button mBtClick;
    @BindView(R.id.rl_root)
    RelativeLayout mRlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBtClick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("test","ontouch-----event=="+event.getAction());
                return false;
            }
        });

    }

    @OnClick({R.id.bt_click, R.id.rl_root})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_click:
                Log.d("test","bt_onclick_Listener");
                break;
            case R.id.rl_root:
                break;
        }
    }

}
