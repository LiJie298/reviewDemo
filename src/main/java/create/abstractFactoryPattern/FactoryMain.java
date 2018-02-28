package create.abstractFactoryPattern;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class FactoryMain {
    public static void main(String[] args) {
        ComputerEngineer computerEngineer = new ComputerEngineer();
        computerEngineer.prepareHardwares(1,2);
        computerEngineer.testMake();
    }
}
