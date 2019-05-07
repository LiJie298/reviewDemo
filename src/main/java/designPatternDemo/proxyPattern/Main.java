package designPatternDemo.proxyPattern;

import designPatternDemo.proxyPattern.cglibProxy.CGLIBProxy;
import designPatternDemo.proxyPattern.cglibProxy.CarService;
import designPatternDemo.proxyPattern.dynamicProxyPattern.ProxyFactory;
import designPatternDemo.proxyPattern.staticProxyPattern.UserDaoProxy;

public class Main {

    /**
     * 动态代理分为两种：
     * *  jdk的动态代理
     * *  代理对象和目标对象实现了共同的接口
     * *  代理类必须实现InvocationHanlder接口
     * <p>
     * *  cglib的动态代理
     * *  代理对象是目标对象的子类
     * *  代理类必须实现MethodInterceptor接口
     * *  hibernate中session.load采用的是cglib实现的
     *
     * @param args
     */
    public static void main(String[] args) {
        //静态代理方式
        UserDao dao = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(dao);
        userDaoProxy.addUser("zhangsan", "lisizhangsan123123");

        //动态代理方式
        ProxyFactory factory = new ProxyFactory(dao);
        IUserDao userDao = (IUserDao) factory.getProxyInstance();
        System.out.println(userDao.getClass());
        userDao.addUser("lisi", "lisizhansan123123");

//        CGLib proxy
        CGLIBProxy cglibProxy = new CGLIBProxy();
        CarService carService = (CarService) cglibProxy.createProxy(new CarService("aodi"));
        System.out.println(carService.getName());

    }
}
