package algorithm;

import java.util.Arrays;

public class MySort {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{12, 5, 34, 299, 6, 3, 89, 100, 45, 7, 4};
//        maopaoSort(a);
//        insertSort(a);
//        fastSort(0, a.length - 1, a);
        a = guiBingSort(0, a.length - 1, a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "->");
        }
    }


    /**
     * 归并排序
     * 总 - 分 - 总
     *
     * @param arrayItems
     */
    public static int[] guiBingSort(int low, int high, int[] arrayItems) {
        if (low >= high) {
            return new int[]{arrayItems[high]};
        }
        int middleIndex = (low + high) / 2;
        int[] leftArray = guiBingSort(low, middleIndex, arrayItems);
        int[] rightArray = guiBingSort(middleIndex + 1, high, arrayItems);
        return guiBingMerge(leftArray, rightArray);
    }

    public static int[] guiBingMerge(int[] left, int right[]) {
        int lLen = left.length, rLen = right.length;
        int i = 0, j = 0, k = 0;
        int[] temp = new int[lLen + rLen];
        //将左右两边的子数组中的元素进行比较
        while (i < lLen && j < rLen) {
            if (left[i] <= right[j]) {
                temp[k++] = left[i++];
            } else {
                temp[k++] = right[j++];
            }
        }

        //将子数组中剩余的元素放入排序数组的后面，下面的两个循环只会执行一个
        while (i < lLen) {
            temp[k++] = left[i++];
        }

        while (j < rLen) {
            temp[k++] = right[j++];
        }

        return temp;
    }


    /**
     * (使用if 时 可以考虑使用while)
     * 取基准值
     * 整个数组与基准值比较，大的放到右边，小的放到左边
     * 重复基准值两侧数据
     *
     * @param a
     */
    public static void fastSort(int low, int high, int[] a) {
        if (low > high) {
            return;
        }
        int staNum = a[low], start = low, end = high;
        while (start < end) {
            while (start < end && a[end] > staNum) {
                end--;
            }
            //交换
            a[start] = a[end];
            a[end] = staNum;
            while (start < end && a[start] < staNum) {
                start++;
            }
            //找到两边 不满足 条件的数据 相互交换
            a[end] = a[start];
            a[start] = staNum;
        }
        //递归
        fastSort(low, end - 1, a);
        fastSort(start + 1, high, a);

    }

    /**
     * 插入排序
     * 取一个指 跟 前面所有做比较，前一个比他大 就把大的放到后面
     *
     * @param arrayItems
     */
    public static void insertSort(int[] arrayItems) {

        for (int i = 1; i < arrayItems.length; i++) {
            int j = i;
            int insert = arrayItems[i];
            while (j >= 1 && arrayItems[j - 1] > insert) {
                //大的放到后面
                arrayItems[j] = arrayItems[j - 1];
                j--;
            }
            arrayItems[j] = insert;
        }
    }


    /**
     * 冒泡排序
     * 两层循环，每次冒出最小的数据
     *
     * @param arrayItems
     */
    public static void maopaoSort(int[] arrayItems) {
        for (int i = 0; i < arrayItems.length; i++) {
            for (int j = i; j < arrayItems.length; j++) {
                //生序
                if (arrayItems[i] >= arrayItems[j]) {
                    //冒泡
                    int a = arrayItems[i];
                    arrayItems[i] = arrayItems[j];
                    arrayItems[j] = a;
                }
            }
        }
    }


}
