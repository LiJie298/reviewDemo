package designPatternDemo.abstractFactoryPattern;

import designPatternDemo.AmdMainboard;
import designPatternDemo.ICpu;
import designPatternDemo.IMainboard;
import designPatternDemo.IntelMainboard;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class MainboardFactory extends AbstractFactory {
    @Override
    ICpu getCpu(int cpuType) {
        return null;
    }

    @Override
    IMainboard getMainBoard(int mainBoardType) {
        IMainboard mainboard = null;
        if(mainBoardType == 1){
            mainboard = new IntelMainboard(755);
        }else if(mainBoardType == 2){
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
