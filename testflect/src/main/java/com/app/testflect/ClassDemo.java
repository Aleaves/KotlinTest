package com.app.testflect;

public class ClassDemo {
    public static void main(String[] args){
        System.out.println("1111111111");

        Foo foo = new Foo();


        Class  c1 = Foo.class;


        Class c2 = foo.getClass();

        try {
            Class c3 = Class.forName("com.app.testflect.foo");
        }catch (Exception e){

        }

    }
}

class  Foo {

}
