package com.app.uicore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.app.uicore.bezier.BezierView;
import com.app.uicore.canvas.SplitView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SplitView(this));
    }
}
