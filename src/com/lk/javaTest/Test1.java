package com.lk.javaTest;


import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author by LiuKui
 * @date 2021/3/2.
 */
public class Test1 {
    public static void main(String[] args) {

//       question1();
//        long start = System.currentTimeMillis();
        question2();
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
        while (true) {
            question3();
        }
    }

    //第一题
    public static void question1() {

        System.out.print("请输入十个数（以空格分割）:\n");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] s1 = s.split(" ");
        int[] A = new int[11];

        for (int i = 0; i < s1.length; i++) {
            A[i] = Integer.parseInt(s1[i]);

        }

        int max = A[0];
        int min = A[0];
        int sum = 0;
        int tag = 0; // 记录最高成绩的出现了几次
        for (int i : A) {
            if (i == max)
                tag++;
            if (i > max) {
                max = i;
                tag = 1;
            }
            if (i < min)
                min = i;
            sum += i;
        }
        double res = (double) sum / A.length;
        BigDecimal bg = new BigDecimal(res);
        System.out.println("最高分：" + max + ",最低分" + min + ",平均分：" +
                bg.setScale(2, BigDecimal.ROUND_HALF_UP) + ",同时存在" + tag + "个并列最高分.");
    }

    //第二题
    public static void question2() {
        int count = 0;
        for (int i = 2; i <= 1_000_000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                if (count == 5) {
                    System.out.println();
                    count = 0;
                }
                System.out.print(i + " ");
                count++;
            }
        }
    }


    //第三题
    public static void question3() {
        System.out.print("请输入金字塔层数：\n");
        int rows = new Scanner(System.in).nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print((i % 2 == 1 ? "1" : "2") + " ");
            }
/*            int  a=1;
            for (int j = 1; j <=2*(rows-i)-1; j++) {
                System.out.print(a+"-");

                if (j<rows-i){
                    a++;
                }else {
                    a--;
                }*/

            System.out.println();
        }
    }
}


