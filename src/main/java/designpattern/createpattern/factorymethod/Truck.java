package designpattern.createpattern.factorymethod;

/**
 * 卡车交通
 * @author lijie
 * @date 2020-11-10 11:38
 */
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("卡车司机开始出发 ...");
    }
}
