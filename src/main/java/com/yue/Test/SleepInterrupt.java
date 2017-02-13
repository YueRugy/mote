package com.yue.test;

/**
 * Created by admin on 2017/2/10
 */
public class SleepInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                System.out.println("in run() - about to sleep for 20 seconds");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println("in run() - interrupted while sleeping");
                //处理完中断异常后，返回到run（）方法人口，
                //如果没有return，线程不会实际被中断，它会继续打印下面的信息
                return;
            }
            System.out.println("in run() - woke up");

        });


        thread.start();
        Thread.sleep(2000);
        System.out.println("in main() - interrupting other thread");
        thread.interrupt();
        System.out.println("in main() - leaving");
    }
}
