package com.kchmielewski.sda.java6.executors.task05;

import java.util.concurrent.*;

public class ExecutingFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 5 * 12 - 3;
        });


        try {
            System.out.println("Trying to get future...");
            Integer result = future.get();
            System.out.println("Done: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
