package com.app.thing;

import com.app.thing.impl.DiskCacheImpl;
import com.app.thing.impl.MemoryCacheImpl;
import com.app.thing.impl.NetWorkLoadImpl;

public class Facade {

    private String url;
    private MemoryCache memoryCache;
    private DiskCache diskCache;
    private NetWorkLoader netWorkLoader;

    public Facade(String url){
        this.url = url;
        memoryCache = new MemoryCacheImpl();
        diskCache = new DiskCacheImpl();
        netWorkLoader = new NetWorkLoadImpl();
    }

    public void laoder(){
        memoryCache.findByMemory(url);
        diskCache.findByDisk(url);
        netWorkLoader.loadImageFromNet(url);
    }

}
