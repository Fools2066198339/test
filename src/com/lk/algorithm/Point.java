package com.lk.algorithm;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author by LiuKui
 * @date 2021/5/10.
 */
public class Point {
    double a, b, x, y;

    public Point(double a, double b, double x, double y) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num[] = new int[3];
        int max=0;
        while (scanner.hasNext()) {
            String str[] = scanner.nextLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                num[i] = Integer.parseInt(str[i]);
            }
//            Arrays.sort(num);
//            System.out.println(num[2]);
           for (int i = 0; i < num.length; i++) {
               max=0;
                if (num[i]>max){
                    max=num[i];
                }
            }
            System.out.println(max);
        }


    }
}
