package com.example.mylibrary.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.mylibrary.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by sunbaixin on 16/8/17.
 */
public class DialogUtils {


    private static DialogUtils instance = null;


    public static synchronized DialogUtils getInstance() {
        if (instance == null) {
            instance = new DialogUtils();
        }
        return instance;
    }


    private static Dialog dialog;


    /**
     * 此方法描述的是： 显示全屏半透明的dialog
     *
     * @author: sunbx 邮箱：sunbx@baihe.com @version: 2014-4-8 上午9:43:31 @param
     * context @return: void @throws
     */
    public static void showDialog(Context context) {
        closeDialog();
        dialog = new Dialog(context, R.style.dialog_styles);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = View.inflate(context, R.layout.progress_dialog, null);
//        AnimationImageView progress = (AnimationImageView) view.findViewById(R.id.progressBar1);
//        progress.start();
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    return true;
                }
                return false;
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    /**
     * 此方法描述的是： 关闭半透明的dialog
     *
     * @author: sunbx 邮箱：sunbx@baihe.com @version: 2014-4-8 上午9:43:42 @param
     * dialog @return: void @throws
     */
    public static void closeDialog() {
        try {
            if (dialog != null) {
                dialog.cancel();
                dialog.dismiss();
            }
        } catch (Exception e) {

        }
    }

    public static class OnDialgYesNoListener {

        public void onYes(MaterialDialog dialog) {

        }

        public void onNo(MaterialDialog dialog) {

        }
    }

    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts).substring(0, String.valueOf(ts).length() - 3);
        return res;
    }

    public static void showHintDilaog(Activity activity, String title, String hint, String yesText, String noText, final OnDialgYesNoListener onDialgYesNoListener) {
        final MaterialDialog mMaterialDialog = new MaterialDialog(activity);
        mMaterialDialog.setTitle(title);
        mMaterialDialog.setMessage(hint);
        mMaterialDialog.setPositiveButton(yesText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();
                onDialgYesNoListener.onYes(mMaterialDialog);

            }
        });
        mMaterialDialog.setNegativeButton(noText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialgYesNoListener.onNo(mMaterialDialog);
                mMaterialDialog.dismiss();

            }
        });
        mMaterialDialog.show();
    }


    public static void showNoBuy(Activity activity, final OnDialgYesNoListener onDialgYesNoListener) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.dialog_no_buy, null);
        LinearLayout ll_wrap = (LinearLayout) view.findViewById(R.id.ll_wrap);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) ll_wrap.getLayoutParams();
        lp.width = (int) (Utils.getScreenWidth(activity) * 0.92);
        ll_wrap.setLayoutParams(lp);
        final Dialog dialog = new Dialog(activity, R.style.dialog_styles);
        view.findViewById(R.id.tv_see).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                onDialgYesNoListener.onNo(null);
            }
        });
        view.findViewById(R.id.tv_buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                onDialgYesNoListener.onYes(null);
            }
        });
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

}
