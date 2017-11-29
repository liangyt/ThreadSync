package com.liangyt.synchronize;

/**
 * 描述：
 *
 * @author tony
 * @创建时间 2017-11-29 13:42
 */
public class TestObject {
    public void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
