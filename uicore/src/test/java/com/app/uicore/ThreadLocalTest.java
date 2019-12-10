package com.app.uicore;

import org.junit.Test;

public class ThreadLocalTest {

    @Test
    public void test(){
        final ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "123";
            }
        };
        System.out.println(threadLocal.get());
    }

}
