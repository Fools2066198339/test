package com.lk.javaTest;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @author by LiuKui
 * @date 2021/3/3.
 */

public class CardIDDemo {
    public static void main(String[] args) throws ParseException {
        //用死循环反复测试输入、验证、输出
        //注意第一步验证失败不能进入第二步，第二步失败不能进入第三步，所有验证通过才能进行输出。
        CardID t = new CardID();
        String id = " ";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入需要验证的身份证号：");
            id = sc.nextLine();
            t.setCardNum(id);

            if (!t.lengthVerify()) {
                System.out.println("长度有错！请重新输入。");
                continue;
            }
            if (!t.charVerify()) {
                System.out.println("输入非数字字符！请重新输入。");
                continue;
            }  if (!t.placeVerify()) {
                continue;
            }  if (!t.checkCodeVerify()) {
                System.out.println("最后一位验证码错误！请重新输入。");
                continue;
            }
                t.output();

        }

    }

}

