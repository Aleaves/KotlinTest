package com.app.netbase_qrcode.reader;


import java.io.BufferedReader;

public class ReaderAdapter implements BReader {

    private ISReader isReader;

    public ReaderAdapter (ISReader isReader){
        this.isReader = isReader;
    }


    @Override
    public BufferedReader getBReader() {
        return new BufferedReader(isReader.getISReader());
    }
}
