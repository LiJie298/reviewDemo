package reflect;

public class MyReflect {

    public static String s = getString();

    private static String getString() {
        System.out.println("给静态变量赋值的静态方法执行：loading line");
        return "ss";
    }

    public static void test() {
        System.out.println("普通静态方法执行：loading line");
    }

    static {
        System.out.println("reflect process static block");
    }




}
