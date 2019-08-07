package com.app.testflect;

import android.Manifest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringFromJar();
            }
        });

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},100);

        PackageManager manager = getPackageManager();
        PluginClass pluginClass = new PluginClass();

    }

    public static final String DEX = "dex";

    private void getStringFromJar(){
        File jarFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + "new.jar");



        // dex解压释放后的目录
        // dex解压释放后的目录
        // dex解压释放后的目录
        String dexOutputDirs = Environment.getExternalStorageDirectory().toString();
        File dexOutputDir = getDir(DEX, 0);
        if(!jarFile.exists()){
            Log.i("==========","not found jar");
        }

        try {
            Log.i("==========",jarFile.getAbsolutePath());
            Log.i("==========",dexOutputDirs);
            DexClassLoader dexClassLoader = new DexClassLoader(jarFile.getAbsolutePath(),dexOutputDir.getAbsolutePath(),null,getClassLoader());

            Class clazz = dexClassLoader.loadClass("com.app.testdexlib.HelloAndroid");


            Log.i("=======",clazz.getSimpleName());

        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
