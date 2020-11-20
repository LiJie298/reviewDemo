package designpattern.createpattern.abstractfactory;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public abstract class AbstractFactory {
    /**
     * 获取cpu
     *
     * @return
     */
    abstract ICpu getCpu();

    /**
     * 获取mainBoard
     *
     * @return
     */
    abstract IMainBoard getMainBoard();
}
