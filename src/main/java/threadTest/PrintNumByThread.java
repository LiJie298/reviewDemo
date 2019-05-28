package threadTest;

public class PrintNumByThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new PrintJob(1));
        Thread thread1 = new Thread(new PrintJob(2));
        Thread thread2 = new Thread(new PrintJob(3));
        thread.start();
        thread1.start();
        thread2.start();
    }

}

class PrintJob implements Runnable {

    private static volatile int printNum = 0;
    int tag;

    public PrintJob(int tag) {
        this.tag = tag;
    }

    @Override
    public void run() {
        synchronized (PrintNumByThread.class) {
            while (printNum < 75) {
                if (printNum / 5 % 3 + 1 == tag) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(tag+" :" + ++printNum);
                    }
                    PrintNumByThread.class.notifyAll();
                } else {
                    try {
                        PrintNumByThread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
