package com.kingnet.mg.mgbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        PsdEditText psdEditText = (PsdEditText) findViewById(R.id.ppe_pwd);
        psdEditText.initStyle(R.drawable.edit_bg, 6, 0.33f, R.color.color999999, R.color.color999999, 20);
        psdEditText.setOnTextFinishListener(new PsdEditText.OnTextFinishListener() {
            @Override
            public void onFinish(String str) {
                //Toast.makeText(MainActivity.this,"哈哈哈",Toast.LENGTH_SHORT).show();
            }
        });


    }


}
