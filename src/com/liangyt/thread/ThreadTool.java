package com.liangyt.thread;

/**
 * 描述：
 *
 * @author tony
 * @创建时间 2017-11-28 15:26
 */
public class ThreadTool {
    public static ThreadLocal<Integer> tTool = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
}
