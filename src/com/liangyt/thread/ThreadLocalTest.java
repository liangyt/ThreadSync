package com.liangyt.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：每个线程自已有自已的一个安全备份，互不影响
 *
 * @author tony
 * @创建时间 2017-11-28 10:21
 */
@SuppressWarnings("all")
public class ThreadLocalTest {
    public static void main(String[] args) {
        CopyThread ct1 = new CopyThread("ct1");
        CopyThread ct2 = new CopyThread("ct2");
        CopyThread ct3 = new CopyThread("ct3");

        ct1.start();
        ct2.start();
        ct3.start();
    }
}

class CopyThread extends Thread {
    private AtomicInteger ai = new AtomicInteger();
    public CopyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            ThreadTool.tTool.set(ai.addAndGet(1));
            System.out.println(this.getName() + ":" + ThreadTool.tTool.get());
        }
    }
}
