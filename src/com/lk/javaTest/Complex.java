package com.lk.javaTest;

/**
 * @author by LiuKui
 * @date 2021/3/3.
 */


import java.text.DecimalFormat;
import java.util.Objects;

//复数类
public class Complex {


    private double realPart, imagePart;

    //无参构造函数
    public Complex() {
        this.realPart = 0;
        this.imagePart = 0;
    }

    //有构造函数
    public Complex(double r, double i) {
        this.realPart = r;
        this.imagePart = i;
    }

    public double getReal() {
        return realPart;
    }

    public void setReal(double realPart) {
        this.realPart = realPart;
    }

    public double getImage() {
        return imagePart;
    }

    public void setImage(double imagePart) {
        this.imagePart = imagePart;
    }

    //两个复数加法
    public Complex AddComplex(Complex a, Complex b) {
        Complex temp = new Complex();
        temp.realPart = a.realPart + b.realPart;
        temp.imagePart = a.imagePart + b.imagePart;
        return temp;
    }

    //两个复数减法
    public Complex SubComplex(Complex a, Complex b) {
        Complex temp = new Complex();
        temp.realPart = a.realPart - b.realPart;
        temp.imagePart = a.imagePart - b.imagePart;
        return temp;
    }

    //两个复数乘法
    public Complex MultiComplex(Complex a, Complex b) {
        Complex temp = new Complex();
        temp.realPart = a.realPart * b.realPart - a.imagePart * b.imagePart;
        temp.imagePart = a.imagePart - b.imagePart + a.realPart * b.realPart;
        return temp;
    }

    //两个复数除法
    public Complex DivComplex(Complex a, Complex b) {
        Complex temp = new Complex();
        temp.realPart =
                (a.realPart * b.realPart + a.imagePart * b.imagePart) / (Math.pow(b.realPart, 2) + Math.pow(b.imagePart, 2));
        temp.imagePart =
                (a.imagePart * b.realPart + a.realPart * b.imagePart) / (Math.pow(b.realPart, 2) + Math.pow(b.imagePart, 2));
        return temp;
    }

    //一个复数加法
    public Complex ComplexAdd(Complex a) {
        Complex c3 = new Complex();
        c3.realPart = this.realPart + a.realPart;
        c3.imagePart = this.imagePart + a.imagePart;
        return c3;
    }

    //一个复数减法
    public Complex ComplexSub(Complex a) {
        Complex c3 = new Complex();
        c3.realPart = this.realPart - a.realPart;
        c3.imagePart = this.imagePart - a.imagePart;
        return c3;
    }

    //一个复数乘法
    public Complex ComplexMulti(Complex a) {
        double temp = this.imagePart;
        Complex c3 = new Complex();
        c3.realPart = this.realPart * a.realPart - this.imagePart * a.imagePart;
        c3.imagePart = temp * a.realPart + this.realPart * a.imagePart;
        return c3;
    }

    //一个复数除法
    public Complex ComplexDiv(Complex a) {
        double temp = this.realPart;
        Complex c3 = new Complex();
//        if (!(this.getReal() == 0 && this.getImage() == 0 && a.getReal() == 0 && a.getImage() == 0)) {
        c3.realPart =
                (this.realPart * a.realPart + this.imagePart * a.imagePart) / (Math.pow(a.realPart, 2) + Math.pow(a.imagePart, 2));
        c3.imagePart =
                (this.imagePart * a.realPart - temp * a.imagePart) / (Math.pow(a.realPart, 2) + Math.pow(a.imagePart,
                        2));

        return c3;
//        }
//        return a;

    }

    public Complex multiReal(double d) {
        Complex c3 = new Complex();
        c3.realPart = this.realPart * d;
        c3.imagePart = this.imagePart * d;
        return c3;
    }

    public double getMod() {
        return Math.sqrt(Math.pow(this.realPart, 2) + Math.pow(this.imagePart, 2));
    }

    public double getSinArg() {
        return this.imagePart / this.getMod();
    }

    public double getArg() {
        double tan = this.imagePart / this.realPart;
        return Math.atan(tan)/Math.PI*180;
    }

    //复数比较是否相同 equals()和hashcode()
    public boolean equals(Complex o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.realPart, realPart) == 0 &&
                Double.compare(complex.imagePart, imagePart) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imagePart);
    }

    //打印复数
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.###");
        String rp = df.format(this.realPart);
        String ip = df.format(this.imagePart);
        String result = "";
        if (this.realPart != 0) {
            if (this.imagePart == 0) {
                result = rp;
            } else if (this.imagePart == 1) {
                result = rp + "+i";
            } else if (this.imagePart == -1) {
                result = rp + "-i";
            } else if (this.imagePart > 0) {
                result = rp + "+" + ip + "i";
            } else {
                result = rp + ip + "i";
            }
        } else {
            if (this.imagePart == 0) {
                result = "0";
            } else if (this.imagePart == 1) {
                result = "i";
            } else if (this.imagePart == -1) {
                result = "-i";
            } else if (this.imagePart < 0) {
                result = ip + "i";
            }
        }
        return result;


    }
}
//
//        StringBuilder sb = new StringBuilder();//可变字符串对象
//        //保留四位小数，并且去0.
//        //最好用字符串避免精度损失
//        if (this.realPart == 0 && this.imagePart == 0) {
//            return "0";
//        }  if (this.realPart != 0) {
//            String tempR = new BigDecimal(this.realPart).
//                    setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();//保留4位小数，且四舍五入
//            sb.append(tempR);
//        }if (this.imagePart == -1) {
//            sb.append("-i");
//            return sb.toString();
//        }if (this.imagePart == 1) {
//            sb.append("i");
//            return sb.toString();
//        }if (this.imagePart == 0) {//如果为0,返回实部
//            return sb.toString();
//        }if (this.imagePart > 0) {//如果虚部为正，需要添加一个+号。 为-时，不需要添加
//            sb.append("+");
//        }//添加虚部， 复数后面的 i是固定的
//        String tempI = new BigDecimal(this.imagePart).
//                setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
//        sb.append(tempI);
//        sb.append("i");
//        return sb.toString();

