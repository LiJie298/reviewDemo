package create.abstractFactoryPattern;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class DemoMain {

    public static void main(String[] args) {
        AbstractFactory cpuFactory = FactoryProducer.getFactory("cpu");
        AbstractFactory mainBoardFactory = FactoryProducer.getFactory("mainBoard");
        mainBoardFactory.getMainBoard(2).installCPU();
        cpuFactory.getCpu(2).calculate();
    }
}
