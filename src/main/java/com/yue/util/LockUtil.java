package com.yue.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 2017/2/10
 */
public class LockUtil {
    private static final Map<String, Object> taskLock = new ConcurrentHashMap<>();
    private static final Lock task = new ReentrantLock();
    private static final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    public static Object get(String key) {
        task.lock();
        taskLock.putIfAbsent(key, new Object());
        Object lock = taskLock.get(key);
        task.unlock();
        return lock;
    }

    public static void removeTask(String key) {
        taskLock.remove(key);
    }


    public synchronized static Object getVideo(String key) {
        Object object = new Object();
        Object returnObject = map.putIfAbsent(key, new Object());

        return returnObject == null ? object : returnObject;
    }

    public static void set(String key) {
        map.put(key, new Object());
    }

    public static void removeVideo(String key) {
        map.remove(key);
    }


    /*static ExecutorService pool = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());





    static Random random = new Random();


    public static Object get(String string) {
        return taskLock.get(string);
    }

    public static void set(String key) {
        System.out.println(taskLock.putIfAbsent(key, new Object()));
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            pool.submit(new Runnable() {
                int key = random.nextInt(3) + 1;

                @Override
                public void run() {
                    set(String.valueOf(key));
                }
            });
        }

        pool.shutdown();

        System.out.println(taskLock.size());

    }*/


}
