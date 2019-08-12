package com.app.netbase_qrcode.factory;

public class ParameterFactory {

    public static Api createApi(int parameter){
        switch (parameter){
            case 1:
                return new ApiImpl_A();
            case 2:
                return new ApiImpl_B();
            default:
                return null;
        }
    }

}
