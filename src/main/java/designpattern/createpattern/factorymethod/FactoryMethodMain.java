package designpattern.createpattern.factorymethod;

/**
 * @author lijie
 * @date 2020-11-10 12:05
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        Transport transport = Logistics.choseTransport("");
        Transport transport1 = Logistics.choseTransport("road");
        Transport transport2 = Logistics.choseTransport("sea");
        transport.deliver();
        transport1.deliver();
        transport2.deliver();
    }
}
