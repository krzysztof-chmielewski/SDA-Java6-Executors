package com.kchmielewski.sda.java6.executors.task01;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OneThreadedExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println(Thread.currentThread().getName());
        IntStream.rangeClosed(1, 10).boxed().forEach(i -> executorService.submit(() -> System.out.println(Thread.currentThread().getName() + ": " + i)));

        List<Runnable> tasksThatDidNotFinishedExecution = executorService.shutdownNow();

        System.out.println(tasksThatDidNotFinishedExecution);
    }
}
