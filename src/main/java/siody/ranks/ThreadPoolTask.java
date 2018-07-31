package siody.ranks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;

public class ThreadPoolTask {
    static public void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,5,20,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i=0;i<10;i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        pool.shutdown();
        System.out.println(pool.isTerminated());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pool.isTerminated());
    }
}

