package designPatternDemo.proxyPattern.cglibProxy;

public class CarService {
    private String name;

    public CarService(String name) {
        this.name = name;
    }

    public CarService() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
