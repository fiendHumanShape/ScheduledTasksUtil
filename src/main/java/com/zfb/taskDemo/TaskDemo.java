package com.zfb.taskDemo;

public class TaskDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("定时任务启动了");
    }
}
