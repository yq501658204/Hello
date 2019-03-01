package com.example.Hello.util;

public class AsynchronousUtil implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("我现在已经进来了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
