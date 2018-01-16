package com.liangyt.timer;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述：
 * 创建时间 2018-01-15 13:23
 * 作者 liangyongtong
 */
public class Run1 {
    private static Timer timer = new Timer();
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了，时间为：" + LocalDateTime.now());
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();

        try {
            long future = new Date().getTime() - 2000;

            timer.schedule(task, new Date(future));
            System.out.println(LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
