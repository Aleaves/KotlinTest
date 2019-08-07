package com.app.myapp.dex;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.app.myapp.R;

import java.lang.reflect.Method;
import java.util.List;

import dalvik.system.DexClassLoader;

public class OtherApkActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_apk);
        findViewById(R.id.bt_add).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bt_add){
            Intent intent = new Intent("com.vonnie.plugintest.client",null);
            PackageManager manager = getPackageManager();
            List<ResolveInfo> lists = manager.queryIntentActivities(intent,0);
            if(null != lists && !lists.isEmpty()){
                ResolveInfo info = lists.get(0);
                ActivityInfo activityInfo = info.activityInfo;
                String packageName = activityInfo.packageName;
                String dexPath = activityInfo.applicationInfo.sourceDir;
                String dexOutputDir = getApplicationInfo().dataDir;
                String libPath = activityInfo.applicationInfo.nativeLibraryDir;
                DexClassLoader dexClassLoader = new DexClassLoader(dexPath,dexOutputDir,null,getClassLoader());
                try{

                    Class clazz = dexClassLoader.loadClass(packageName + ".MainActivity");
                    Object object = clazz.newInstance();
                    Method method = clazz.getMethod("add",int.class,int.class);
                    int result = (int)method.invoke(object,1,1);
                    Log.i("========",result+"");
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
}
