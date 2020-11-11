package designpattern.createpattern.factorymethod;

import java.util.Calendar;

/**
 * 运输方式
 *
 * @author lijie
 * @date 2020-11-10 11:45
 */
public class Logistics {

    /**
     * 获取运输工具
     *
     * @param type 工具选择
     * @return 运输工具
     */
    public static Transport choseTransport(String type) {
        Transport transport = null;
        switch (type) {
            case "road":
                transport = new Truck();
                break;
            case "sea":
                transport = new Ship();
                break;
            default:
                transport = new Truck();
                break;
        }
        return transport;
    }
}
