package create.factoryPattern;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class ComputerEngineer {
    private ICpu cpu;
    private IMainboard mainboard;

    /**
     * 组装
     *
     * @param cpuType
     * @param mainboard
     */
    public void prepareHardwares(int cpuType, int mainboard) {
        this.cpu = CpuFactory.createCpu(cpuType);
        this.mainboard = MainboardFactory.createMainboard(mainboard);
    }

    public void testMake(){
        cpu.calculate();
        mainboard.installCPU();
    }
}
