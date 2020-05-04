package threadTest.CreateThead;


import java.util.List;

/**
 * 创建线程的各个方式
 *
 * @author lijie
 * @date 2020-05-04 11:30
 */
public class CreateRunnable implements Runnable {

    private List<String> resources;

    public CreateRunnable(List<String> resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        if (!resources.isEmpty()) {
            resources.stream().forEach(System.out::println);
        }
    }
}
