package threadTest;

public class MyPrintNumberByThreads {

    private static volatile int num = 0;
    private static Object a1 = new Object();
    private static Object a2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                synchronized (a1) {
                    synchronized (a2) {
                        for (int i = 0; i < 5; i++) {
                            System.out.println(Thread.currentThread().getId() + " -- " + ++num);
                        }
                    }
                }
                a1.wait();
                a2.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        Thread thread2 = new Thread(() -> {
            synchronized (a1) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getId() + " -- " + ++num);
                }
            }
            a2.notify();
        });

        Thread thread3 = new Thread(() -> {
            synchronized (a2) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getId() + " -- " + ++num);
                }
            }
            a1.notify();
        });

        while (num < 75) {
            thread1.start();
            thread2.start();
            thread3.start();
        }


    }
}
