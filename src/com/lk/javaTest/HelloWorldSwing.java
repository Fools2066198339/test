package com.lk.javaTest;

/**
 * @author by LiuKui
 * @date 2021/3/13.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class HelloWorldSwing {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] num = {11,55,66,43,13,78,26,39,40};
        System.out.println(arrayToString(num,"输入"));
        QuickSort(num,0,num.length-1);
        System.out.println(arrayToString(num,"输出"));
//		System.out.println("数组长度："+num.length);
//		System.out.println("循环次数："+count);
    }

    /**
     * 快速排序
     * @param num	排序的数组
     * @param left	数组的前针
     * @param right 数组后针
     */
    public static int count=0;
    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回

        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        count++;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);

    }
    /**
     * 将一个int类型数组转化为字符串
     * @param arr
     * @param flag
     * @return
     */
    private static String arrayToString(int[] arr,String flag) {
        String str = flag+":";
        for(int a : arr) {
            str += a + "\t";
        }
        return str;
    }

}
