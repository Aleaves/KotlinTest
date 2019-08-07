package com.app.myapp.pack.ui;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.app.myapp.R;

import java.util.List;

public class PackManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apck);

        //getPackageInfo();
        isAvilible();

    }

    private void getPackageInfo(){
        PackageManager manager = getPackageManager();
        try {
            PackageInfo packageInfo = manager.getPackageInfo("com.app.myapp",PackageManager.GET_ACTIVITIES);
            //获取versionCode 和versionName
            Log.i("=========",packageInfo.versionName+"==");
            //获取包名下所有的activity
            ActivityInfo[] activities = packageInfo.activities;
            for (ActivityInfo info:activities) {
                Log.i("=======",info.name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void isAvilible(){
        PackageManager packageManager = getPackageManager();
        List<PackageInfo> lists = packageManager.getInstalledPackages(0);
        for (PackageInfo info:lists
             ) {

            String appName = packageManager.getApplicationLabel(info.applicationInfo).toString();
            Log.i("=======",info.applicationInfo.packageName + appName);

        }
    }


}
