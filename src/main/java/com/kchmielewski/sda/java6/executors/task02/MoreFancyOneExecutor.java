package com.kchmielewski.sda.java6.executors.task02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MoreFancyOneExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10).boxed().forEach(i -> executorService.submit(() -> {
            try {
                System.out.println("Currently working thread is " + Thread.currentThread().getName());
                System.out.println("Sleeping for one second...");
                Thread.sleep(1000);
                System.out.println("And done: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        executorService.shutdown();
    }
}
