package threadTest;

import java.util.concurrent.Semaphore;

/**
 * 交替输出abcabcabc
 */
public class MyPrintNumberByThreads {

    private static volatile int num = 0;
    private static Object a1 = new Object();
    private static Object a2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Semaphore c = new Semaphore(0);
        Thread thread1 = new Thread( new Worker(a, b, "A", 3));
        Thread thread2 = new Thread( new Worker(b, c, "B", 3));
        Thread thread3 = new Thread( new Worker(c, a, "C", 3));
        thread2.start();
        thread1.start();
        thread3.start();

        Thread.sleep(2000);

    }

    public static class Worker implements Runnable {
        private String key;
        private Semaphore current;
        private Semaphore next;
        private Integer count;

        public Worker(Semaphore current, Semaphore next, String key, Integer count) {
            this.current = current;
            this.next = next;
            this.key = key;
            this.count = count;
        }

        public void run() {
            for (int i = 0; i < count; i++) {
                try {
                    //获取当前的锁
                    current.acquire(); //current - 1
                    System.out.print( key);
                    //释放next的锁
                    next.release();    //next + 1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
