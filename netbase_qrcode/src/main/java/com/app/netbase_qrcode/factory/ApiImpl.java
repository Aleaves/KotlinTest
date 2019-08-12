package com.app.netbase_qrcode.factory;

import android.util.Log;

public class ApiImpl implements Api{

    @Override
    public UserInfo create() {
        UserInfo userInfo = new UserInfo("qwer",12);
        System.out.println(userInfo.toString());
        return userInfo;
    }

}
