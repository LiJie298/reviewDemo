package designpattern.createpattern.abstractfactory;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class AmdFactory extends AbstractFactory {
    @Override
    ICpu getCpu() {
        return new AmdCpu(100);
    }

    @Override
    IMainBoard getMainBoard() {
        return new AmdMainBoard(200);
    }
}
