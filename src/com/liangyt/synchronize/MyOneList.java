package com.liangyt.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 创建时间 2017-12-28 10:02
 * 作者 liangyongtong
 */
@SuppressWarnings("all")
public class MyOneList {
    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        MyOneList list = new MyOneList();
        Thread1 thread1 = new Thread1(list);
        thread1.setName("A");
        thread1.start();
        Thread2 thread2 = new Thread2(list);
        thread2.setName("B");
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.getSize());
    }
}

class Myservice {
    public MyOneList addServiceMethod(MyOneList list, String data) {
        try {
            // 因为各线程判断长度时都是0，所以这里需要进行同步
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return list;
    }
}

class Thread1 extends Thread {
    private MyOneList list;
    public Thread1(MyOneList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        Myservice myservice = new Myservice();
        myservice.addServiceMethod(list, "A");
    }
}

class Thread2 extends Thread {
    private MyOneList list;
    public Thread2(MyOneList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        Myservice myservice = new Myservice();
        myservice.addServiceMethod(list, "B");
    }
}
