package designpattern.createpattern.abstractfactory;

import designpattern.AmdCpu;
import designpattern.ICpu;
import designpattern.IMainboard;
import designpattern.IntelCpu;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class CpuFactory extends AbstractFactory {
    @Override
    ICpu getCpu(int cpuType) {
        ICpu cpu = null;
        if (1 == cpuType) {
            cpu = new AmdCpu(333);
        } else if (2 == cpuType) {
            cpu = new IntelCpu(256);
        }
        return cpu;
    }

    @Override
    IMainboard getMainBoard(int mainBoardType) {
        return null;
    }
}
