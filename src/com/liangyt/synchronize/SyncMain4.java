package com.liangyt.synchronize;

/**
 * 描述：这个还有点没有明白 synchronized(otherobject)
 *
 * @author tony
 * @创建时间 2017-11-29 13:44
 */
@SuppressWarnings("all")
public class SyncMain4 {
    public static void main(String[] args) {
        Test4 t1 = new Test4();

        new Thread("t1") {
            @Override
            public void run() {
                t1.syncBlock();
            }
        }.start();

        new Thread("t2") {
            @Override
            public void run() {
                t1.syncBlock();
            }
        }.start();

        // 先停一下主线程，好看结果
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Test4 t2 = new Test4();

        new Thread("t3") {
            @Override
            public void run() {
                t2.syncBlock();
            }
        }.start();

        new Thread("t4") {
            @Override
            public void run() {
                t2.syncFunction();
            }
        }.start();
    }
}

class Test4 {
    TestObject to = new TestObject();

    public Test4() {
    }

    public void syncBlock() {
        synchronized (to) {
            to.print();
        }
    }

    public synchronized void syncFunction() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "-syncFunction:" + i);
        }
    }
}
