package com.liangyt.synchronize;

/**
 * 描述：同步的静态方法、同步的普通方法、普通方法这三者之间，在多线程的情况可以同时被访问。互不影响
 *
 * @author tony
 * @创建时间 2017-11-29 11:13
 */
@SuppressWarnings("all")
public class SynchronizedTest2 {

    /**
     * 同步静态方法
     */
    public static synchronized void syncStaticFunction(String f) {
        System.out.println(Thread.currentThread().getName() + " 进入方法 syncStaticFunction");
        System.out.println(f + "--我是线程：" + Thread.currentThread().getName() + ( "run".equals(f) ? "" : ", 我先休息1秒" ));
        try {
            if ("run".equals(f)) Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(f + "--我是线程：" + Thread.currentThread().getName() + ", 我离开了");
    }

    /**
     * 同步静态方法
     */
    public static synchronized void syncStaticFunction2(String f) {
        System.out.println(Thread.currentThread().getName() + " 进入方法 syncStaticFunction2");
        System.out.println(f + "--我是线程：" + Thread.currentThread().getName() + ( "run".equals(f) ? "" : ", 我先休息1秒" ));
        try {
            if ("run".equals(f)) Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(f + "--我是线程：" + Thread.currentThread().getName() + ", 我离开了");
    }

    /**
     * 同步方法
     */
    public synchronized void syncFunction() {
        System.out.println(Thread.currentThread().getName() + " 进入方法 syncFunction");
        run("syncFunction");
    }

    /**
     * 同步方法
     */
    public synchronized void syncFunction2() {
        System.out.println(Thread.currentThread().getName() + " 进入方法 syncFunction2");
        run("syncFunction2");
    }

    /**
     * 普通方法
     * @param f
     */
    public void run(String f) {
        System.out.println(f + "--我是线程：" + Thread.currentThread().getName() + ( "run".equals(f) ? "" : ", 我先休息1秒" ));
        try {
            if ("run".equals(f)) Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(f + "--我是线程：" + Thread.currentThread().getName() + ", 我离开了");
    }
}
