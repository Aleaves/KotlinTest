package com.app.netbase_qrcode.reader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ISReaderImpl implements ISReader {

    private FileInputStream is;

    public ISReaderImpl(FileInputStream is){
        this.is = is;
    }

    @Override
    public InputStreamReader getISReader() {
        return new InputStreamReader(is);
    }

}
