package com.liangyt.synchronize;

/**
 * 描述：
 *
 * @author tony
 * @创建时间 2017-11-29 13:00
 */
@SuppressWarnings("all")
public class SyncMain2 {
    public static void main(String[] args) {
        SynchronizedTest2 st = new SynchronizedTest2();
        ThreadGenerate2 tg1 = new ThreadGenerate2("tg1", st, 1);
        ThreadGenerate2 tg2 = new ThreadGenerate2("tg2", st, 2);
        ThreadGenerate2 tg3 = new ThreadGenerate2("tg3", st, 3);

        tg1.start();
        tg2.start();
        tg3.start();

//        某个运行结果:
//        tg1 进入方法 syncFunction
//        run--我是线程：tg3
//        tg2 进入方法 syncStaticFunction
//        syncStaticFunction--我是线程：tg2, 我先休息1秒
//        syncFunction--我是线程：tg1, 我先休息1秒
//        syncFunction--我是线程：tg1, 我离开了
//        syncStaticFunction--我是线程：tg2, 我离开了
//        run--我是线程：tg3, 我离开了
    }
}

class ThreadGenerate2 extends Thread {
    SynchronizedTest2 synchronizedTest2;
    int type = 0;
    public ThreadGenerate2(String name, SynchronizedTest2 synchronizedTest2, int type) {
        super(name);
        this.synchronizedTest2 = synchronizedTest2;
        this.type = type;
    }

    @Override
    public void run() {
        if (this.type == 1) {
            this.synchronizedTest2.syncFunction();
        } else if (this.type == 2) {
            SynchronizedTest2.syncStaticFunction("syncStaticFunction");
        } else if (this.type == 3) {
            this.synchronizedTest2.run("run");
        }
    }
}
