package com.kingnet.myview;

import android.os.Bundle;

import com.kingnet.myview.wave.BezierView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_load);
        //setContentView(new BezierView(this));
    }
}
