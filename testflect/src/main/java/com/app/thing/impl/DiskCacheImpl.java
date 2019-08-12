package com.app.thing.impl;

import android.graphics.Bitmap;

import com.app.thing.DiskCache;

public class DiskCacheImpl implements DiskCache {

    @Override
    public Bitmap findByDisk(String url) {
        System.out.println("通過圖片url，尋找本地文件中的緩存圖片");
        return null;
    }
}
