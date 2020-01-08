package algorithm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MySort {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        maopaoSort(a);
//        insertSort(a);
//        fastSort(0, a.length - 1, a);
//        a = guiBingSort(0, a.length - 1, a);
//        a = heapSort(a);
//        System.out.println(maxSubArray(a));

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);
        ListNode res = mergeTwoLists(listNode, listNode1);
//        System.out.println(res);
        System.out.println(hasSomeStr("abc","xxabctscbb"));

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "->");
        }
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> a = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!a.contains(s.charAt(i))) {
                a.add(s.charAt(i));
            } else {
                a = new HashSet();
            }
            max = Math.max(max, a.size());
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int total = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            total = Math.max(temp, total);
        }
        return total;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prehead = new ListNode(0);
        ListNode res = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return prehead.next;
    }


    public static int[] heapSort(int[] a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < a.length; i++) {
            minHeap.add(a[i]);
        }
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = minHeap.poll();
        }
        return b;
    }

    public static void heapTest(int k, int object, int[] queue) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            int e = queue[parent];
            if (object >= e) {
                break;
            }
            queue[k] = e;
            k = parent;
        }
        queue[k] = object;
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
//        Class.forName();
//        ClassLoader.getClassLoader();
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

    public static boolean hasSomeStr(String a, String b) {
        if (b == null || a == null) {
            return false;
        }
        if (b.length()<a.length()){
            return false;
        }
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            if (a.indexOf(b.charAt(i)) != -1) {
                num.append(b.charAt(i));
            }
        }
        return num.toString().contains(a);
    }


}
