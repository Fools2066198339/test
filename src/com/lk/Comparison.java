package com.lk;

import java.util.*;

/**
 * @author by LiuKui
 * @date 2021/4/17.
 */
public class Comparison<al> {

    public static void main(String args[]) {
        int a[] = {1, 2, 3};
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            hashSet.add(a[i]);
        }
        hashSet.add(5);
        System.out.println(hashSet);
        String s1 = "abc" + "def";
        String s2 = new String(s1);
        if (s1 == s2)
            System.out.println("==succeeded");
        if (s1.equals(s2))
            System.out.println(".equals() succeeded");
        ArrayList<String> al = new ArrayList<String>();
        List<Integer> arr=new LinkedList<>();
        HashMap<Integer,String> hashMap =new HashMap<Integer,String>();
        al.add("abc");

        System.out.println(al);
    }


}
