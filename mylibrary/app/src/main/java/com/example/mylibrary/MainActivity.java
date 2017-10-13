package com.example.mylibrary;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mylibrary.Utils.DialogUtils;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.showDialog(MainActivity.this);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtils.closeDialog();
                    }
                },3000);
            }
        });
    }
}
