package com.manager.crm.task;

import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class CustomerTask {

    @Scheduled(cron = "0/2 * *  * * ?")
    public void customerTaskAdd(){
        System.out.println("h啊哈哈哈， 我是定时任务,老马臭傻逼");
    }
}
