package threadTest.CreateThead;

import java.util.Collection;

/**
 * @author lijie
 * @date 2020-05-04 11:35
 */
public class ThreadNew extends Thread {


    private Collection<String> res;

    public ThreadNew(Collection<String> res) {
        this.setName("Extend_Thread_ThreadNew");
        this.res = res;
    }

    @Override
    public void run() {
        super.run();
        res.stream().forEach(System.out::println);
    }
}
