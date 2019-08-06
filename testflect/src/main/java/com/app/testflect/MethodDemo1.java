package com.app.testflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class MethodDemo1 {


    public static void main(String[] args){
        A a1 = new A();
        Class c = a1.getClass();


        try {
            Method method =  c.getMethod("print",int.class,int.class);
            method.invoke(a1,1,2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}

class A{

    public void print(int a ,int b ){
        System.out.println(a+b);
    }

    public void print(String a,String b){
        System.out.println(a+b);

    }

}
