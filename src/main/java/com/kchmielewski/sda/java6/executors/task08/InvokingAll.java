package com.kchmielewski.sda.java6.executors.task08;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InvokingAll {
    private static AtomicInteger counter = new AtomicInteger();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Callable<Integer>> integers = IntStream.rangeClosed(1, 10000).boxed()
                .map(i -> (Callable<Integer>) () -> counter.incrementAndGet()).collect(Collectors.toList());
        try {
            List<Future<Integer>> futures = executorService.invokeAll(integers);
            futures.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
