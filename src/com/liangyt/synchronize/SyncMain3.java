package com.liangyt.synchronize;

/**
 * 描述：
 *
 * @author tony
 * @创建时间 2017-11-29 13:30
 */
@SuppressWarnings("all")
public class SyncMain3 {
    public static void main(String[] args) {
        SynchronizedTest2 st = new SynchronizedTest2();

        new Thread("t1") {
            @Override
            public void run() {
                st.syncFunction();
            }
        }.start();

        new Thread("t2") {
            @Override
            public void run() {
                st.syncFunction2();
            }
        }.start();

//        运行结果： 运行结果不会改变，同一个实例对象下的不同同步普通方法只能在同一个时间运行一个
//        t1 进入方法 syncFunction
//        syncFunction--我是线程：t1, 我先休息1秒
//        syncFunction--我是线程：t1, 我离开了
//        t2 进入方法 syncFunction2
//        syncFunction2--我是线程：t2, 我先休息1秒
//        syncFunction2--我是线程：t2, 我离开了

        new Thread("t3") {
            @Override
            public void run() {
                SynchronizedTest2.syncStaticFunction("syncStaticFunction");
            }
        }.start();

        new Thread("t4") {
            @Override
            public void run() {
                SynchronizedTest2.syncStaticFunction2("syncStaticFunction2");
            }
        }.start();

//        运行结果： 运行结果不会改变，同一个类下的不同同步静态方法只能在同一个时间运行一个
//        t3 进入方法 syncStaticFunction
//        syncStaticFunction--我是线程：t3, 我先休息1秒
//        syncStaticFunction--我是线程：t3, 我离开了
//        t4 进入方法 syncStaticFunction2
//        syncStaticFunction2--我是线程：t4, 我先休息1秒
//        syncStaticFunction2--我是线程：t4, 我离开了
    }
}
