package designpattern.createpattern.abstractfactory;


import designpattern.createpattern.abstractfactory.ICpu;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class AmdCpu implements ICpu {

    /**
     * CPU的针脚数
     */
    private int pins = 0;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数：" + pins);
    }
}
