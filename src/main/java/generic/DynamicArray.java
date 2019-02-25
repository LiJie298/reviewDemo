package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DynamicArray<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public DynamicArray(int size, Object[] elementData) {
        this.size = size;
        this.elementData = elementData;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity) {
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public void set(int index, E data) {
        elementData[index] = data;
    }


    /**
     * @param dest 使用超类型通配符  <? super E>
     */
    public void copyTo(DynamicArray<? super E> dest) {
        for (int i = 0; i < size; i++) {
            dest.add(get(i));
        }
    }

    /**
     * @param e I ) < T extends E ＞
     *          用于 定义类型参数，它声明了一个类型参数 T,
     *          可放在泛型类定义中类名后面 、 泛型方法返回值前面 。
     *          2 ) < ? extends E ＞
     *          用于 实例化类型参数，它用于实例化泛型变量中的类型参数,只是这个具体类型是未知的，只知道它是 E 或 E 的某个子类型 。
     *          <p>
     *          除了有限定通配符，还有 一 种通配符，形如 DynamicArray ＜？＞， 称 为 无限定通配符 。
     *          还有一种通配符，与形式 ＜ ？ extends E＞ 正好相反，它的形 式 为 ＜ ？ super E＞ ，称 为 超类型通配符，表示 E 的某个父类型。
     *          现在我们再来看泛型方法到底应该用 通配符 的形式还是加 类型参数 。 两者 到 底有什么关 系 ？ 我们总结如下 。
     *          1 ）通配符形式都可以用类型参数的形式来替代，通配符能做的，用 类型参 数都能 做 。
     *          2 ）通配符形式可以减少类型参数，形式上往往更为简单，可读性也更好 ， 所以， 能用通配符的就用通配符 。
     *          3 ）如果类型参数之间有依赖关系，或者返回值依赖 类型参数， 或者 需要写操作 ， 则只能用类型参数 。
     *          4 ）通配符形式和类型参数往往配合使用， 定义必要的类型参 数，使用通配符表达依赖，并接受更广泛的数据类型 。
     *          <p>
     *          <? super E> 超类型通配符 应用灵活写入
     *          <?>  <? extents E>  应用于灵活读取
     *          <p>
     *          public static <T extends Comparable<? super T >> void sort(List<T> list)
     *          public static <T> void sort(List<T> list, Comparator<? super T> c)
     *          public static <T> void copy(List<? super T> dest, List<? extends T> src)
     *          public static <T> T max(Collection<? extends T> coll , Comparator<? super T> comp)
     */
    //    public <T extends E> void addAll(DynamicArray<T> e) {
    public void addAll(DynamicArray<? extends E> e) {
        for (int i = 0; i < e.size; i++) {
            add(e.get(i));
        }
    }

    public static void main(String[] args) {
        DynamicArray<Double> array = new DynamicArray();
        Random random = new Random();
        int size = random.nextInt(100) + 1;
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            array.add(Math.random());
        }
        System.out.println(array.get(random.nextInt(size)));


        DynamicArray<Number> numberDynamicArray = new DynamicArray();
        DynamicArray<Integer> integerDynamicArray = new DynamicArray();
        integerDynamicArray.add(1);
        integerDynamicArray.add(2);
        numberDynamicArray.addAll(integerDynamicArray);


        List<String>  list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(2,"0");
        list.stream().forEach(System.out::println);
    }

    public static int indexOf(DynamicArray<?> arr, Object elm) {
        for (int i = 0; i < arr.size; i++) {
            if (arr.get(i).equals(elm)) {
                return i;
            }
        }
        return -1;
    }
}

