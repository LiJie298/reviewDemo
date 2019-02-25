package generic;

import java.io.File;
import java.io.IOException;

/**
 *  T 表示类型参数， 泛型就是类型参数化，处理的数据类型不是固定的，
 *  * 而T是可以作为参数传入 。
 * @param <T>
 */
public class Demo<T> {
    private T t1;
    private T t2;

    public Demo(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }

    public T getT2() {
        return t2;
    }

    public void setT2(T t2) {
        this.t2 = t2;
    }

    class Demo2<U,V>{
        U first;
        V second;

        public Demo2(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        String filepath ="/mnt/source3/pmop/storage_raw/2019/0121/9631623_test";
        File file = new File(filepath);
        if(!file.getParentFile().exists()){
            file.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
