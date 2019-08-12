package com.app.testflect;
import com.app.thing.DiskCache;
import com.app.thing.Facade;
import com.app.thing.MemoryCache;
import com.app.thing.NetWorkLoader;
import com.app.thing.impl.DiskCacheImpl;
import com.app.thing.impl.MemoryCacheImpl;
import com.app.thing.impl.NetWorkLoadImpl;
import org.junit.Test;
public class MainActivityTest {

    private final static String URL = "http://www.163.com/logo.jpg";

    @Test
    public void onCreate() {

//        MemoryCache memoryCache = new MemoryCacheImpl();
//        memoryCache.findByMemory(URL);
//
//        DiskCache diskCache = new DiskCacheImpl();
//        diskCache.findByDisk(URL);
//
//        NetWorkLoader netWorkLoader = new NetWorkLoadImpl();
//        netWorkLoader.loadImageFromNet(URL);
        Facade facade = new Facade(URL);
        facade.laoder();


    }
}