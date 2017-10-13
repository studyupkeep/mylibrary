package com.example.mylibrary.Utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.Toast;

/**
 * Created by liujian on 2017/10/13.
 */

public class Utils {

    public static void showToast(Context context){
        Toast.makeText(context,"Toast",Toast.LENGTH_LONG).show();
    }

    /**
     * 获取屏幕宽高
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
