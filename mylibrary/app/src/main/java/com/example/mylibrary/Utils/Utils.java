package com.example.mylibrary.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by liujian on 2017/10/13.
 */

public class Utils {

    public static void showToast(Context context){
        Toast.makeText(context,"Toast",Toast.LENGTH_LONG).show();
    }
}
