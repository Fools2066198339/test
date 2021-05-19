package com.lk;

import java.util.Scanner;

/**
 * @author by LiuKui
 * @date 2021/3/23.
 */
class TraintimeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入时间:");

        Traintime date = new Traintime();
        date.setDay(scanner.nextInt());
        date.setHour(scanner.nextInt());
        date.setMinute(scanner.nextInt());
        System.out.println(date);

    }
}