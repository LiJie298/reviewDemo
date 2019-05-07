package reflect;

public class Main {

    /**
     * 反射中，Class.forName和classloader的区别:
     * Class.forName()  这个会把 。class文件加载到 jvm 中，并且执行静态代码块。
     * Classloader 只是把 class 文件加载到jvm 中，并不会执行static代码块
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Object a = Class.forName("reflect.MyReflect");
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            loader.loadClass("reflect.MyReflect");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
