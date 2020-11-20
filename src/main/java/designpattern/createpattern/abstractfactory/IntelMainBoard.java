package designpattern.createpattern.abstractfactory;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class IntelMainBoard implements IMainBoard {

    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     *
     * @param cpuHoles
     */
    public IntelMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("intel主板安装了cpu，CPU插槽的孔数为：" + cpuHoles);
    }
}
