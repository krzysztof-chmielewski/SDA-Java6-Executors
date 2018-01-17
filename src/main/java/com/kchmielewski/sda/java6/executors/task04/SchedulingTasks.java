package com.kchmielewski.sda.java6.executors.task04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        long time = System.currentTimeMillis();
        executorService.schedule(
                () -> System.out.println("I will be running after some time: " + (System.currentTimeMillis() - time)),
                1, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(
                () -> System.out.println("I will be running after some time periodically at fixedRate: " + (System.currentTimeMillis() - time)),
                1, 1, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(
                () -> System.out.println("I will be running after some time periodically with fixedDelay: " + (System.currentTimeMillis() - time)),
                1, 1, TimeUnit.SECONDS);

        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
