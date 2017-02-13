package com.yue.test;

/**
 * Created by admin on 2017/2/10
 */
public class YieldClass {

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("I am Producer : Produced Item " + i);

                }
            }
        });

        Thread customer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("I am customer : customer Item " + i);

                }
            }
        });



        producer.setPriority(Thread.MAX_PRIORITY);
        customer.setPriority(Thread.MIN_PRIORITY);

        producer.start();
        producer.join();
        customer.start();

    }


}
