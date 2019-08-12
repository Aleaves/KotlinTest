package com.app.thing;

import android.graphics.Bitmap;

public interface DiskCache {

    Bitmap findByDisk(String url);

}
