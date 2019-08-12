package com.app.netbase_qrcode.factory;

public class SimpleFactory {

    public static Api createApi(){
        return new ApiImpl();
    }

}
