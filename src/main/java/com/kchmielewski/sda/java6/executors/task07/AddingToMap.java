package com.kchmielewski.sda.java6.executors.task07;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class AddingToMap {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        IntStream.rangeClosed(1, 10000).boxed().forEach(i -> executorService.submit(() -> map.put(i, i * i)));
        executorService.shutdown();

        System.out.println(map.size());
    }

}
