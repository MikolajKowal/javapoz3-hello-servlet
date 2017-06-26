package com.sda.threads;

import java.util.Arrays;
import java.util.List;

public class SumApplication {
    public static void main(String[] args) throws InterruptedException {

        SumTask sumTask = new SumTask(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 5, 3, 6, 7, 5, 3));
        SumTask sumTask2 = new SumTask(Arrays.asList(6, 4, 3, 56, 7, 9, 6, 4, 6, 8, 5, 3, 2));
        SumTask sumTask3 = new SumTask(Arrays.asList(35, 3, 5, 86));
        SumTask sumTask4 = new SumTask(Arrays.asList(350, 3, 5, 86));
        SumTask sumTask5 = new SumTask(Arrays.asList(3500, 3, 5, 86));
        SumTask sumTask6 = new SumTask(Arrays.asList(35000, 3, 5, 86));

        Thread thread = new Thread(sumTask);
        Thread thread2 = new Thread(sumTask2);
        Thread thread3 = new Thread(sumTask3);
        Thread thread4 = new Thread(sumTask4);
        Thread thread5 = new Thread(sumTask5);
        Thread thread6 = new Thread(sumTask6);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        Thread.sleep(2000);


        Summer summer = Summer.getInstance();
        System.out.println(summer.getSize());
        System.out.println(summer.getNumbers());
        System.out.println(summer.sumElements());
    }
}
