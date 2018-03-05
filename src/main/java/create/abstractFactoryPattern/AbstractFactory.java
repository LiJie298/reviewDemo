package create.abstractFactoryPattern;

import create.ICpu;
import create.IMainboard;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public abstract class AbstractFactory {
    /**
     * 获取cpu
     * @param cpuType
     * @return
     */
    abstract ICpu getCpu(int cpuType);

    /**
     * 获取mainBoard
     * @param mainBoardType
     * @return
     */
    abstract IMainboard getMainBoard(int mainBoardType);
}
