package com.liangyt.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述：ReentrantLock、ReentrantReadWriteLock都支持重新获取锁(重进入);
 * ReentrantLock: 具有排它性，一个线程持有锁时其它线程只能等待，直到持有线程释放锁;
 * ReentrantReadWriteLock:具有读锁和写锁，读锁具有公平选择性，可以交替执行，但顺序不保证，写锁具有排它性；都支持重新获取锁；
 *
 * @author tony
 * @创建时间 2017-11-29 21:30
 */
@SuppressWarnings("all")
public class LockSync {
    Lock lock = new ReentrantLock();
    ReadWriteLock lockRW = new ReentrantReadWriteLock();

    public void lock() {
        lock.lock();
        for(int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

    public void lockR() {
        lockRW.readLock().lock();
        for(int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lockRW.readLock().unlock();
    }
}
