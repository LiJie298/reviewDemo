package mianshi;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 求符合正则 [a-zA-z0-9]{5,}字符串中出现的第一个出现一次的字符，如果不存在 返回 空字符串；
 * ["bacddc","0106218286","x1k0yxzk1","acebadcedbf"]
 */
public class FindStrFirstChar {


    public static void main(String[] args) {

//        String[] str = new String[]{"bacddc", "0106218286", "x1k0yxzk1", "acebadcedbf"};
//
//        for (int i = 1; i < str.length; i++) {
//            System.out.println("findStr   " + str[i] + " - >" + findStr(str[i]));
//            System.out.println("findStrAfter   " + str[i] + " - >" + findStrAfter(str[i]));
//        }
//
//        doSomeThing();
        ddd();
    }

    /**
     * 面试的时候写的  使用了 jdk的方法，点击去才发现  里面实现使用的 arrayList实现的
     * 当时没有考虑到 split 不会最后一位分出来；
     *
     * @param str
     * @return
     */
    private static String findStr(String str) {
        str = str + "@";
        char[] temp = str.toCharArray();
        for (int i = 0; i < temp.length - 1; i++) {
            int num = str.split(String.valueOf(temp[i])).length;
            if ((i == 0 && num == 1) || num == 2) {
                return String.valueOf(temp[i]);
            }
        }
        return "";
    }


    private static String findStrAfter(String str) {
        ArrayList<Character> a = new ArrayList();

        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (!a.contains(character)) {
                a.add(character);
            } else {
                a.remove(character);
            }
        }
        if (a.size() > 0) {
            return a.get(0).toString();
        }
        return "";
    }


    public static void doSomeThing() {
        int a1 = 0;
        a:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                a1++;
                if (j + i == 100) {
                    break a;
                }

            }
        }
        System.out.println("跳出成功 :" + a1);
    }


    private static void ddd(){
        HashSet set = new HashSet();
        for (int i = 0; i < 100; i++) {
            set.add(i);
            set.remove(i-1);
        }
        System.out.println(set.size());
    }
}
