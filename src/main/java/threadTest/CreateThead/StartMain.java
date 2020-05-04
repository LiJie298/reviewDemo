package threadTest.CreateThead;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lijie
 * @date 2020-05-04 11:35
 */
public class StartMain {

    public static void main(String[] args) {
        List<String> res = new LinkedList<>();

        for (int i = 0; i < 300000; i++) {
            res.add(String.valueOf(i));
        }

        Thread t3 = new Thread(() -> {

        });

        ThreadNew threadNew = new ThreadNew(res.subList(0, 100000));
        CreateCallable createCallable = new CreateCallable(res.subList(100001, 200000));
        CreateRunnable createRunnable = new CreateRunnable(res.subList(200001, 300000));

        Thread t1 = new Thread(createRunnable, "createRunnable");
        ExecutorService executorService = Executors.newFixedThreadPool(1, Executors.defaultThreadFactory());
        Future future = executorService.submit(createCallable);
        threadNew.start();
        t1.start();
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }

    }
}
