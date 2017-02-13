package com.yue.test;

import java.util.Random;

/**
 * Created by admin on 2017/2/10
 */
public class StopClass {
    private static final int[] array = new int[80000];

    private static final Thread t = new Thread() {
        @Override
        public void run() {
            try {
                System.out.println(sort(array));
            } catch (Error err) {
                err.printStackTrace();
            }
            System.out.println("in thread t");
        }
    };


    static {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(i + 1);
        }
    }

    private static int sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array[0];
    }

    public static void main(String[] args) throws InterruptedException {
       /* t.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("go to stop thread t");
        t.stop();
        System.out.println("finish main");*/

       /* Thread t = Thread.currentThread();
        System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());
        //待决中断，中断自身
        t.interrupt();
        System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());
        System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(2);
            //Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        } catch (InterruptedException x) {
            System.out.println("was interrupted");
        }
        //抛出异常后，会清除中断标志，这里会返回false
        System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());*/
        System.out.println(
                "Point X: Thread.interrupted()=" + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("Point Y: Thread.interrupted()=" + Thread.interrupted());
        System.out.println("Point Y2: Thread.interrupted()=" + Thread.interrupted());
        System.out.println(
                "Point Z: Thread.interrupted()=" + Thread.interrupted());
    }
}
