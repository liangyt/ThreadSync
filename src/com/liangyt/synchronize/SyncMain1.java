package com.liangyt.synchronize;

/**
 * 描述：
 *
 * @author tony
 * @创建时间 2017-11-29 10:28
 */
public class SyncMain1 {
    public static void main(String[] args) {
        SynchronizedTest1 st = new SynchronizedTest1();
        ThreadGenerate1 tg1 = new ThreadGenerate1("tg1", st);
        ThreadGenerate1 tg2 = new ThreadGenerate1("tg2", st);
        ThreadGenerate1 tg3 = new ThreadGenerate1("tg3", st);

        tg1.start();
        tg2.start();
        tg3.start();

    }
}

class ThreadGenerate1 extends Thread {
    private SynchronizedTest1 synchronizedTest;

    public ThreadGenerate1(String name, SynchronizedTest1 synchronizedTest) {
        super(name);
        this.synchronizedTest = synchronizedTest;
    }

    @Override
    public void run() {
        // 可以尝试一下把这里的方法顺序换个位置看看结果
        synchronizedTest.syncFunction();
        synchronizedTest.run("run");
        synchronizedTest.syncInFunction();
    }
}
