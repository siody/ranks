package siody.javabasic;

import org.junit.Test;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    @Test
    public void givenUsingTimer_whenSchedulingTaskOnce_thenCorrect() throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on: " + new Date() + "n" +
                        "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        timer.schedule(task, delay);
        Thread.sleep(delay*2);
    }

    @Test
    public void givenUsingTimer_whenSchedulingRepeatedTask_thenCorrect() throws InterruptedException {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };
        Timer timer = new Timer("Timer");

        long delay  = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(repeatedTask, 0, period);
        Thread.sleep(delay*10);
    }

    @Test
    public void givenUsingTimer_whenCancelingTimerTask_thenCorrect()
            throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
                cancel();
            }
        };
        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(task, 1000L, 1000L);

        Thread.sleep(1000L * 3);
        timer.cancel();
        Thread.sleep(1000L * 2);
    }
}
