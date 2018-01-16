package com.liangyt.threadgroup;

/**
 * 描述：线程组里加线程组
 * 创建时间 2018-01-16 09:47
 * 作者 liangyongtong
 */
public class Run2 {
    public static void main(String[] args) {
        System.out.println("线程组名称：" + Thread.currentThread().getThreadGroup().getName());

        System.out.println("线程组中活动的线程数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());

        // 当前线程加子线程组
        ThreadGroup newGroup = new ThreadGroup(Thread.currentThread().getThreadGroup(), "newGroup");

        System.out.println("线程组中活动的线程数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());

        System.out.println("父线程组名称:" + Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
