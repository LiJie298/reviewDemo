package designpattern.createpattern.abstractfactory;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class IntelFactory extends AbstractFactory {
    @Override
    ICpu getCpu() {
        return new IntelCpu(300);
    }

    @Override
    IMainBoard getMainBoard() {
        return new IntelMainBoard(120);
    }
}
