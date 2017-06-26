package com.sda.threads;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        Runnable myTask = new MyTask("one");
        Runnable myTask2 = new MyTask("two");
        Runnable myTask3 = new MyTask("three");

//        myTask.run();
//        myTask2.run();
//        myTask3.run();

        Thread thread = new Thread(myTask);
        Thread thread2 = new Thread(myTask2);
        Thread thread3 = new Thread(myTask3);

        System.out.println("starting thread one");
        thread.start();
//        thread.start();
        System.out.println("starting thread two");
        thread2.start();
        System.out.println("starting thread three");
        thread3.start();
    }
}
