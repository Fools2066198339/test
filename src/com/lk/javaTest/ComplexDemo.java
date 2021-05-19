package com.lk.javaTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ComplexDemo {
    public static void main(String[] args) {

        Complex[] complexs = new Complex[]{new Complex(3, 2),
                new Complex(3, -2), new Complex(4, 1), new Complex(4, -1),
                new Complex(1, 1), new Complex(0, 0), new Complex(0, -2),
                new Complex(0, 1), new Complex(0, -1)};

        for (Complex i : complexs) {
            System.out.print(i + ",");
        }
        System.out.println("\n" + "请输入你想输入的几组数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i < n + 2; i++) {

            Complex c1 = inComplex(i);
            Complex c2 = inComplex(++i);

            System.out.println("啦啦啦运算******************");
            System.out.println("c1=" + c1 + "\n" + "c2=" + c2);
            System.out.println(c1.toString() + "与" + c2.toString() + "是否相同:" + c1.equals(c2));
            System.out.println("-----------------------");
            System.out.println("四则运算结果：");
            System.out.println("加法:\n" + "c1" + "+" + "c2" + "= " + c1.ComplexAdd(c2));
            System.out.println("减法:\n" + "c1" + "-" + "c2" + "= " + c1.ComplexSub(c2));
            System.out.println("乘法:\n" + "c1" + "*" + "c2" + "= " + c1.ComplexMulti(c2));

            if (!(c1.getReal() == 0 && c1.getImage() == 0 && c2.getReal() == 0 && c2.getImage() == 0)) {
                System.out.println("除法:\n" + "c1" + "/" + "c2" + "= " + c1.ComplexDiv(c2));
            } else {
                System.out.println("无法进行除法！");
            }

        }
    }
    public static Complex inComplex(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第" + i + "个复数:");
        double realPart = scanner.nextDouble();
        double imagePart = scanner.nextDouble();
        return new Complex(realPart, imagePart);


//        Scanner scanner = new Scanner(System.in);
//        double r = scanner.nextDouble();
//        double i = scanner.nextDouble();
//        Complex c4=new Complex(r,i);
//        System.out.println(c4);
//        DecimalFormat df = new DecimalFormat("#.###");
//        DecimalFormat df2 = new DecimalFormat("#.#");
//        System.out.println( "c1.mod="+df.format(c4.getMod()));
//        System.out.println( "c1.sinArg="+df.format(c4.getSinArg()));
//        System.out.println( "c1*5="+c4.multiReal(5));
//        System.out.println( "c1.Arg="+df.format(c4.getArg()));
    }


}