package designpattern.createpattern.abstractfactory;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class AmdMainBoard implements IMainBoard {

    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     *
     * @param cpuHoles
     */
    public AmdMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("安装了cpu，CPU插槽的孔数为：" + cpuHoles);
    }
}
