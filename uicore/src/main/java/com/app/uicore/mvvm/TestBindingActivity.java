package com.app.uicore.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.app.uicore.R;
import com.app.uicore.databinding.ActivityTestBindingBinding;
import com.app.uicore.mvvm.model.UserInfo;

public class TestBindingActivity extends AppCompatActivity {

    private UserInfo userInfo = new UserInfo();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test_binding);

//        userInfo.setUsername("llb");
//        userInfo.setPassword("123456");
//
//        binding.setUser(userInfo);
//
//        Log.i("===========",userInfo.getUsername()+"==="+userInfo.getPassword());
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                userInfo.setUsername("abc");
//                userInfo.setPassword("147258");
//                Log.i("===========",userInfo.getUsername()+"==="+userInfo.getPassword());
//            }
//        },3000);

        userInfo.username.set("llb");
        userInfo.password.set("123456");
        binding.setUser(userInfo);
        Log.i("==========",userInfo.username.get()+"==="+userInfo.password.get());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                userInfo.username.set("abc");
//                userInfo.password.set("147258");
                Log.i("==========",userInfo.username.get()+"==="+userInfo.password.get());
            }
        },10000);

    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });

    //谷歌备胎api 不推荐使用
    private Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
        handler = null;
    }
}
