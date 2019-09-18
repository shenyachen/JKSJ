package com.jksj.study;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yachen.shen
 * @Date 2019/9/18 22:32
 * threadLocal Study
 */
public class ThreadLocalStu extends Thread{

    private static ThreadLocal<List> threadLocal = new ThreadLocal();
    private static List myList = new ArrayList();
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new ThreadLocalStu());
        thread.start();

        Thread thread2 = new Thread(new ThreadLocalStu());
        thread2.start();
    }

    @Override
    public void run() {
        threadLocal.set(myList);
        List list = threadLocal.get();
        for (int i = 0; i < 1000; i ++) {
            list.add(i);
        }
        System.out.println(list.size());

    }
}
