package com.myorganisation.gurukul.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationJob {

    @Scheduled(cron = "0 0 1 1-7 * SUN")
    public void sendNotification3() {
        System.out.println("Sending notification... Time: " + LocalDateTime.now());
    }

    // every seconds
//    @Scheduled(cron = "* * * * * ?")
//    public void sendNotification() {
//        System.out.println("Sending notification... Time: " + LocalDateTime.now());
//    }

    // every 5 seconds
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void sendNotification2() {
//        System.out.println("Sending notification... Time: " + LocalDateTime.now());
//    }

    @Scheduled(cron = "0 0 1 1-7 * SUN")
    public void sendNotification2() {
        System.out.println("Sending notification... Time: " + LocalDateTime.now());
    }
}






















