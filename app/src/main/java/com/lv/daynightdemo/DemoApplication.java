package com.lv.daynightdemo;

import android.app.Application;

/**
 * Created by Lv on 2016/9/27.
 */

public class DemoApplication extends Application {

    public static boolean IS_DAY_MODE;//是否是日间模式

    @Override
    public void onCreate() {
        super.onCreate();
        //系统自动确实现在是晚上还是白天
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }
}
