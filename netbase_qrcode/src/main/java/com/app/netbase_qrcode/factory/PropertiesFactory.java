package com.app.netbase_qrcode.factory;

import android.content.Context;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFactory {

    public static Api createApi(Context context){
        //加載配置文件
        Properties props = new Properties();
        try {
            InputStream inputStream = context.getAssets().open("config.properties");

            props.load(inputStream);

            Class clazz = Class.forName(props.getProperty("create_a"));
            return (Api) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
