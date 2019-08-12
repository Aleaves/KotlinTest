package com.app.netbase_qrcode.factory;

public class ApiImpl_B implements Api{
    @Override
    public UserInfo create() {

        UserInfo userInfo = new UserInfo("B",2);
        System.out.println(userInfo.toString());

        return userInfo;
    }
}
