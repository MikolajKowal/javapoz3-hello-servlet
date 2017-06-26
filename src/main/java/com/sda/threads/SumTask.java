package com.sda.threads;

import java.util.List;

public class SumTask implements Runnable {
    private List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = list.stream()
                .mapToInt(e -> e)
                .sum();
        Summer.getInstance().add(sum);
        Summer.getInstance().test();
    }
}
