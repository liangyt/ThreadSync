package com.liangyt.threadgroup;

/**
 * 描述：获取根线程组
 * 创建时间 2018-01-16 09:39
 * 作者 liangyongtong
 */
public class Run1 {
    public static void main(String[] args) {
        System.out.println("线程:" + Thread.currentThread().getName() + " 所在线程组名称为:" + Thread.currentThread().getThreadGroup().getName());

        System.out.println(Thread.currentThread().getThreadGroup().activeGroupCount());

        System.out.println("main 线程所在的线程组的父线程的名称是： " + Thread.currentThread().getThreadGroup().getParent().getName());
//        System.out.println("main 线程所在的线程组的父线程的父线程的名称是： " + Thread.currentThread().getThreadGroup().getParent().getParent().getName());
    }
}
