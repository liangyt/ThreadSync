package com.liangyt.lock;

/**
 * 描述：
 *
 * @author tony
 * @创建时间 2017-11-29 21:37
 */
public class LockMain1 {
    public static void main(String[] args) {
        LockSync ls = new LockSync();

        new Thread("t1") {
            @Override
            public void run() {
                ls.lock();
            }
        }.start();

        new Thread("t2") {
            @Override
            public void run() {
                ls.lock();
            }
        }.start();

        new Thread("t3") {
            @Override
            public void run() {
                ls.lockR();
            }
        }.start();

        new Thread("t4") {
            @Override
            public void run() {
                ls.lockR();
            }
        }.start();

//        某次运行结果：线程 t1 永远运行在 线程 t2 的前面；线程 t3 和 线程 t4 交替运行
//        t1:0
//        t3:0
//        t4:0
//        t1:1
//        t3:1
//        t4:1
//        t1:2
//        t3:2
//        t4:2
//        t2:0
//        t2:1
//        t2:2
    }
}
