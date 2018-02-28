package create.abstractFactoryPattern;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class IntelCpu implements ICpu {
    /**
     * CPU的针脚数
     */
    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Intel CPU的针脚数：" + pins);
    }
}
