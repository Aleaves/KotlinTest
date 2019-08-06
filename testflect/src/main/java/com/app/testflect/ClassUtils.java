package com.app.testflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtils {


    public static void printClassMessage(Object obj){
        Class c = obj.getClass();

        //打印类的名称
        System.out.println(c.getSimpleName());

        //所有的方法
        Method[] methods = c.getMethods();

        //自己申明的
        Method[] methods1 = c.getDeclaredMethods();

        for (Method ms: methods) {

            System.out.println(ms.getReturnType().getSimpleName());

            System.out.println(ms.getName());

            Class[] paramTypes = ms.getParameterTypes();

            for (Class class1 : paramTypes){
                System.out.print(class1.getSimpleName());
            }

        }

        Field[] fields = c.getDeclaredFields();

        for (Field f:fields) {
            Class fileType = f.getType();
            System.out.println(fileType.getSimpleName());
        }

    }



    public static void printFieldMessage(Object obj){
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f:fields) {
            Class fileType = f.getType();
            System.out.println(fileType.getSimpleName());
        }
    }

    public static void printConstructorMessage(Object obj){
        Class c = obj.getClass();
        Constructor[] constructors = c.getConstructors();
        for (Constructor con:
             constructors) {

        }
    }

    public static void main(String[] args){
        String a = "1";
        //printClassMessage(a);
        printFieldMessage("123");
    }

}
