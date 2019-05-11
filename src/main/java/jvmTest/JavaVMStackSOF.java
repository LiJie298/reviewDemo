package jvmTest;

public class JavaVMStackSOF {

    private int stackLength;

    public void add(){
        stackLength++;
        add();
    }

    private void dontStop(){
        while (true){

        }
    }
    public void stackLeakByThread(){
        while(true){
            new Thread(()->dontStop());
        }
    }

    /**
     *虚拟机栈里存放的都是
     *  每个方法执行的同时创建的局部变量表，操作数栈，动态链表，出口信息
     *  方法迭代调用
     *VM ARGS -Xss128k
     */

    public  void m1ain(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try{
            javaVMStackSOF.add();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("-----"+javaVMStackSOF.stackLength);
        }
    }

    /**
     * 多线程
     * @param args
     */
    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try{
            javaVMStackSOF.add();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
