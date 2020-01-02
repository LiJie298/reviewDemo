package designpattern.proxyPattern.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {
    private Object target;


    public Object createProxy(Object object) {
        this.target = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    private void aopMethod() {
        System.out.println("CGLIB proxy method effective:" + this.target.getClass());
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        aopMethod();
        Object a  = method.invoke(this.target, objects);
        return a;
    }
}
