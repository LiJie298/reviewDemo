package threadTest.CreateThead;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author lijie
 * @date 2020-05-04 11:36
 */
public class CreateCallable implements Callable<String> {

    private List<String> resources;


    public CreateCallable(List<String> resources) {
        this.resources = resources;
    }

    @Override
    public String call() throws Exception {
        return "ddd";
    }
}
