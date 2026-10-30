package com.att;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // runAsync
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(
                () -> System.out.println("Running in:"+ Thread.currentThread().getName())
        );
        completableFuture.get(10, TimeUnit.SECONDS);

        //supplyAsync
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() ->  {
            return "Hello from Another Thread!!";
        });
        String result = stringCompletableFuture.join();
        System.out.println(result);

        //Chaining operations

        //thenApply
        CompletableFuture<String> chainFutureTransform = CompletableFuture.supplyAsync(() -> {
            return "hello";
        }).thenApply(String::toUpperCase);
        System.out.println(chainFutureTransform.join());

        //thenAccept
        CompletableFuture.supplyAsync(() -> "hello")
                         .thenAccept(System.out::println);

        //thenRun
        CompletableFuture.supplyAsync(() -> 10)
                .thenRun(() -> System.out.println("Running Thread:" + Thread.currentThread().getName()));

    }
}
