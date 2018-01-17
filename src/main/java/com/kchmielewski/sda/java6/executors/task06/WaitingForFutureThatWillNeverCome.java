package com.kchmielewski.sda.java6.executors.task06;

import java.util.concurrent.*;

public class WaitingForFutureThatWillNeverCome {
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
            Integer result = future.get(2, TimeUnit.SECONDS);
            System.out.println("Done: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Whoops, no chance to get that future!");
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
