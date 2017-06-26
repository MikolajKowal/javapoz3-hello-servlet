package com.sda.counter;

public class CounterTask implements Runnable {

    @Override
    public void run() {
        CounterSummaryProvider provider = CounterSummaryProvider.getInstance();
        CounterSummaryService service = CounterSummaryService.getInstance();
        int threadCounter = 0;
        while (provider.hasNext()) {
            threadCounter++;
            if (provider.getNextValue() % 2 == 0) {
                service.increase();
            }
        }
        System.out.println("Proceeded: " + threadCounter);
    }
}
