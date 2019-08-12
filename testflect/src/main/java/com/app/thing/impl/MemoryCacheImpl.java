package com.app.thing.impl;

import android.graphics.Bitmap;

import com.app.thing.MemoryCache;

public class MemoryCacheImpl implements MemoryCache {

    @Override
    public Bitmap findByMemory(String url) {
        System.out.println("通過圖片url尋找內存中的緩存圖片");
        return null;
    }
}
