package create.factoryPattern;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class CpuFactory {

    public static final int ADM = 1;
    public static final int INTEL = 2;

    public static ICpu createCpu(int type) {
        ICpu cpu = null;
        if (ADM == type) {
            cpu = new AmdCpu(333);
        } else if (INTEL == type) {
            cpu = new IntelCpu(256);
        }
        return cpu;

    }
}
