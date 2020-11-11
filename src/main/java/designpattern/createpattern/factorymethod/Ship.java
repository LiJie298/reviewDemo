package designpattern.createpattern.factorymethod;

/**
 * 船
 * @author lijie
 * @date 2020-11-10 11:39
 */
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("船长开始出发 ...");
    }
}
