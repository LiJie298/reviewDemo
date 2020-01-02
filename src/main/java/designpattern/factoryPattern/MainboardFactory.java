package designpattern.factoryPattern;

import designpattern.AmdMainboard;
import designpattern.IMainboard;
import designpattern.IntelMainboard;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class MainboardFactory {

    public static final int ADM = 1;
    public static final int INTEL = 2;


    public static IMainboard createMainboard(int type){
        IMainboard mainboard = null;
        if(type == ADM){
            mainboard = new IntelMainboard(755);
        }else if(type == INTEL){
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
