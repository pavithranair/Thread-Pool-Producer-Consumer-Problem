package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Buffer buffer = new Buffer(5);

        ThreadPool threadPool = new ThreadPool(3);

        threadPool.execute(new Consumer(buffer, "1"));
        threadPool.execute(new Consumer(buffer, "2"));
        Future producerStatus1 = threadPool.submit(new Producer(buffer, "A"));
        producerStatus1.get();

    }
}
