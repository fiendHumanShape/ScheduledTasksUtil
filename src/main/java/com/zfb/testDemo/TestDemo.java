package com.zfb.testDemo;

import com.zfb.Cron4jUtil.Cron4jUtil;
import com.zfb.taskDemo.TaskDemo;

/**
 * @author zhangFengBo
 * 测试定时任务
 * */
public class TestDemo {
    public static void main(String[] args) {
        //每分钟执行一次
        String cron4j="* * * * *";
        //注任务名称必须唯一
        Cron4jUtil.put("任务名称",cron4j,new TaskDemo(),false);
        //停止定时任务
        Cron4jUtil.stop("任务名称");
    }
}
