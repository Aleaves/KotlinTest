package com.app.uicore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.app.uicore.bezier.BezierView;
import com.app.uicore.bezier.PathView;
import com.app.uicore.colorfilter.ColorFilterView;
import com.app.uicore.view.ComposeView;
import com.app.uicore.view.PaintView;
import com.app.uicore.xfermode.EraserView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new BezierView(this));

    }
}
