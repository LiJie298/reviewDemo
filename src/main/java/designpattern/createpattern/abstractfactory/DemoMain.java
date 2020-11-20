package designpattern.createpattern.abstractfactory;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class DemoMain {

    public static void main(String[] args) {
        AbstractFactory abstractFactory;
        if (args.length > 0) {
            abstractFactory = new AmdFactory();
        } else {
            abstractFactory = new IntelFactory();
        }
        ICpu iCpu = abstractFactory.getCpu();
        IMainBoard mainBoard = abstractFactory.getMainBoard();

        iCpu.calculate();
        mainBoard.installCPU();
    }
}
