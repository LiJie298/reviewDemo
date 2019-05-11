package jvmTest;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject{

    }

    /**
     * 设置堆参数
     * VM ARGS :    -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> oomObjects = new ArrayList<>();
       while(true){
               oomObjects.add(new OOMObject());
       }
    }
}
