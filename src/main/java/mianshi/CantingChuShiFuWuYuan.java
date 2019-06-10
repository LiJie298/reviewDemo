package mianshi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 饭店里的有3个厨师和2个服务员,限务员必须等待厨师准备好膳食,厨师随机制作鱼香肉丝或宫保鸡丁两道菜。
 * 厨师每隔3分钟可以做好一道菜,每个服务员每隔1分钟看是否有已完成，如果有,则取走上菜,无论是否有菜,眼务员都要等待1分，
 * 上菜顺序要按照厨师完成食准的顺序进行；
 */
public class CantingChuShiFuWuYuan {
    private static ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

    class Chief implements Runnable {

        private void makeYu() {
            System.out.println(Thread.currentThread().getName() + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " " + " : make yu");
            queue.add("Yu");
        }

        private void makeGong() {
            System.out.println(Thread.currentThread().getName() + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " " + " : make gong");
            queue.add("gong");
        }


        Random random = new Random();

        @Override
        public void run() {
            while (true) {
                int type = random.nextInt(2);

                if (type == 1) {
                    makeGong();
                } else {
                    makeYu();
                }
                try {
                    Thread.sleep(30 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiter implements Runnable {

        @Override
        public void run() {
            while (true) {
                sendFood();
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        private void sendFood() {
            if (queue.size() > 0) {
                Object a = queue.poll();
                System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " : send food " + a.toString());
            } else {
                System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " : no food ");
            }
        }

    }

    public void doJob() {
        Thread w1 = new Thread(new Waiter(), "waiter1");
        Thread w2 = new Thread(new Waiter(), "waiter2");
        Thread c1 = new Thread(new Chief(), "chief1");
        Thread c2 = new Thread(new Chief(), "chief2");
        Thread c3 = new Thread(new Chief(), "chief3");
        c1.start();
        c2.start();
        c3.start();
        w1.start();
        w2.start();
    }

    public static void main(String[] args) {
        CantingChuShiFuWuYuan cantingChuShiFuWuYuan = new CantingChuShiFuWuYuan();
        cantingChuShiFuWuYuan.doJob();
    }

}
