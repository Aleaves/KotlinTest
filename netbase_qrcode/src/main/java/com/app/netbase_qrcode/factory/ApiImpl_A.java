package com.app.netbase_qrcode.factory;

public class ApiImpl_A implements Api{

    @Override
    public UserInfo create() {
        UserInfo userInfo = new UserInfo("A",1);
        System.out.println(userInfo.toString());

        return userInfo;
    }
}
