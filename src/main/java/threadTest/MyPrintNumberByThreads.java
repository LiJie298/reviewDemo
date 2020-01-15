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

//        Semaphore a = new Semaphore(1);
//        Semaphore b = new Semaphore(0);
//        Semaphore c = new Semaphore(0);
//        Thread thread1 = new Thread(new Worker(a, b, "A", 3));
//        Thread thread2 = new Thread(new Worker(b, c, "B", 3));
//        Thread thread3 = new Thread(new Worker(c, a, "C", 3));
//        thread2.start();
//        thread1.start();
//        thread3.start();
//        Thread.sleep(2000);
        start1();
        System.exit(0);

    }

    public static void start1() throws InterruptedException {
        Object oA = new Object();
        Object oB = new Object();
        Object oC = new Object();
        Thread t1 = new Thread(new PrintChar("A", oC, oA));
        Thread t2 = new Thread(new PrintChar("B", oA, oB));
        Thread t3 = new Thread(new PrintChar("C", oB, oC));

        t1.start();
        Thread.sleep(10);
        t2.start();
        Thread.sleep(10);
        t3.start();
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
                    System.out.print(key);
                    //释放next的锁
                    next.release();    //next + 1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class PrintChar implements Runnable {

        private Object pre;
        private Object self;
        private String temp;

        public PrintChar(String temp, Object pre, Object self) {
            this.pre = pre;
            this.self = self;
            this.temp = temp;
        }

        @Override
        public void run() {
            int count = 3;
            while (count > 0) {
                synchronized (pre) {
                    synchronized (self) {
                        count--;
                        System.out.print(temp);
                        //唤醒下一步操作的锁
                        self.notifyAll();
                    }
                    try {
                        //释放前一个锁
                        pre.wait();
                    } catch (InterruptedException e) {
//                    e.printStackTrace();
                    }
                }

            }

        }
    }
}
