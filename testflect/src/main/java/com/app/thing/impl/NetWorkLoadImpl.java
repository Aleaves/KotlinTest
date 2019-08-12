package com.app.thing.impl;

import com.app.thing.NetWorkLoader;

import java.io.InputStream;

public class NetWorkLoadImpl  implements NetWorkLoader {
    @Override
    public InputStream loadImageFromNet(String url) {
        System.out.println("通過圖片url，從網絡加載緩存圖片");
        return null;
    }
}
