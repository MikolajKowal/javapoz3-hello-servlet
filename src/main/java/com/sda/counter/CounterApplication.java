package com.sda.counter;

public class CounterApplication {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new CounterTask());
        Thread thread2 = new Thread(new CounterTask());
        Thread thread3 = new Thread(new CounterTask());

        thread.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);

        System.out.println(CounterSummaryService.getInstance().get());
    }
}
