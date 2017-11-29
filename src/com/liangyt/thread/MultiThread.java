package com.liangyt.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：定义一个线程，共享一个数据
 *
 * @author tony
 * @创建时间 2017-11-28 15:25
 */
public class MultiThread extends Thread {
    /** 定义一个静态的原子性的整数变量，这样不管这个类生成多少个实例都是使用的同一个原子实例 */
    private static AtomicInteger ai = new AtomicInteger();

    public MultiThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ThreadTool.tTool.set(ai.addAndGet(1));
            System.out.println(this.getName() + ":" + ThreadTool.tTool.get());
        }
    }
}
