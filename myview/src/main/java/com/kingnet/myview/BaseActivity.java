package com.kingnet.myview;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.i("=============1",hasFocus+"");
        super.onWindowFocusChanged(hasFocus);
    }
}
