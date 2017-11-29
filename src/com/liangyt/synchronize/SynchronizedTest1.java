package com.liangyt.synchronize;

/**
 * 描述：类锁(内置锁)  只要线程执行到了 synchronized (this) 或者是 运行了 public synchronized void syncFunction() 则其它的线程如果想执行这些代码的时候需要等待
 * 但其它未加锁的方法可以被其它的线程执行
 *
 * @author tony
 * @创建时间 2017-11-29 10:06
 */
public class SynchronizedTest1 {

    /**
     * 块
     */
    public void syncInFunction() {
        System.out.println(Thread.currentThread().getName() + " 进入方法 syncInFunction");
        synchronized (this) {
            run("syncInFunction");
        }
    }

    /**
     * 同步方法
     */
    public synchronized void syncFunction() {
        System.out.println(Thread.currentThread().getName() + " 进入方法 syncFunction");
        run("syncFunction");
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
