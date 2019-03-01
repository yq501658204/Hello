package com.example.Hello.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TestUtil {

    @Async
    public void test(){
        try {
            Thread.sleep(5000);
            System.out.println("我这个是线程池里面的线程，所以就是这么的简单！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
