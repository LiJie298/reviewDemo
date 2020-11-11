package designpattern.createpattern.abstractfactory;


import designpattern.IMainboard;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryName){
        if(StringUtils.isNotBlank(factoryName)){
            IMainboard mainboard = null;
            if(factoryName.toLowerCase().equals("cpu")){
              return new CpuFactory();
            }else if(factoryName.toLowerCase().equals("mainboard")){
               return new MainboardFactory();
            }
        }
        return null;
    }
}
