package com.kchmielewski.sda.java6.executors.task03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenMoreFancyOneExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        IntStream.rangeClosed(1, 10).boxed().forEach(i -> executorService.submit(() -> System.out.println(Thread.currentThread().getName() + ": " + i)));

        executorService.shutdown();
    }
}
