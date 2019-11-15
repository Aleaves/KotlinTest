package com.app.uicore.rec.myrec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.uicore.R;

public class MyRecActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rec);
        recyclerView = findViewById(R.id.table);
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public View onCreateViewHodler(int position, View convertView, ViewGroup parent) {
                convertView = MyRecActivity.this.getLayoutInflater().inflate(R.layout.item_table,parent,false);
                TextView textView= (TextView) convertView.findViewById(R.id.text1);
                textView.setText("网易课堂 "+position);
                return convertView;
            }

            @Override
            public View onBinderViewHodler(int position, View convertView, ViewGroup parent) {
                TextView textView= (TextView) convertView.findViewById(R.id.text1);
                textView.setText("网易课堂 "+position);
                return null;
            }

            @Override
            public int getItemViewType(int row) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public int getHeight(int index) {
                return 100;
            }
        });
    }


}
