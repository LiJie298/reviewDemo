package jvmTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JavaMethodAreaOOM {

    /**
     * java 方法区
     *  存放的 是 类的解释信息，exp： 类名，访问修饰符，常量池，字段描述，方法描述等。
     *  使用cglib 生成大量的类，
     *  Java1.7
     *  —XX:PermSize=5M -XX:MaxPermSize=10M
     *
     *  java1.8 移除了 方法区永久带的空间
     *  在移除了Perm区域之后，JDK 8中使用MetaSpace来替代，这些空间都直接在堆上来进行分配。  在JDK8中，类的元数据存放在native堆中，这个空间被叫做：元数据区。JDK8中给元数据区添加了一些新的参数。
     *  -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=7M
     * @param args
     */
    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MethodOOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });
            enhancer.create();
        }
    }
    static  class MethodOOM {

    }
}
