package com.lide.event.paint;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lide.event.R;

/**
 * @author DaiJiCheng
 * @time 2018/3/21  9:43
 * @desc ${TODD}
 */
public class PaintViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

//        //获得闹钟管理器
//        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
//        //设置任务执行计划
//        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime, 5*1000, sender);//从firstTime才开始执行，每隔5秒再执行
    }
}
