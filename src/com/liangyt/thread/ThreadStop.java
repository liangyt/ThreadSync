package com.liangyt.thread;

/**
 * 描述：
 * 创建时间 2017-12-18 09:24
 * 作者 liangyongtong
 */
public class ThreadStop {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(10);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            if (Thread.interrupted()) {
                System.out.println("已经是停止状态了，我要退出了");
                break;
            }
            System.out.println("i=" + i);
        }

        System.out.println("我还在运行");
    }
}
