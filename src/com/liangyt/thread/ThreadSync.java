package com.liangyt.thread;

/**
 * 描述：起多个线程访问数据
 *
 * @author tony
 * @创建时间 2017-11-28 15:39
 */
@SuppressWarnings("all")
public class ThreadSync {
    public static void main(String[] args) {
        MultiThread mt1 = new MultiThread("t1");
        MultiThread mt2 = new MultiThread("t2");
        MultiThread mt3 = new MultiThread("t3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
}
