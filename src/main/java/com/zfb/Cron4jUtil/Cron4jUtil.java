package com.zfb.Cron4jUtil;


import it.sauronsoftware.cron4j.Scheduler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangFengBo
 * 支持corn4j表达式的定时任务
 * */
public class Cron4jUtil {

    //创建map集合
    private static final Map<String, Scheduler> schedulerMap
            = new ConcurrentHashMap<String, Scheduler>();
    // 线定时任务中添加数据
    public static void put(String name, String cron,
                           Runnable task, boolean daemon) {
        //获取是否存在该定时任务，如果存在则进行关闭
        Scheduler old = schedulerMap.get(name);
        if (old != null && old.isStarted()) {
            stop(name);
        }
        //配置定时任务
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(cron, task);
        scheduler.setDaemon(daemon);
        schedulerMap.put(name, scheduler);
        //启动任务
        scheduler.start();
    }


    // 启动定时任务
    public static void start(String name) {
        Scheduler scheduler = schedulerMap.get(name);
        if (scheduler != null) {
            scheduler.start();
        }
    }



    // 关闭定时任务
    public static void stop(String name) {
        Scheduler scheduler = schedulerMap.get(name);
        if (scheduler != null) {
            scheduler.stop();
        }
    }




}
