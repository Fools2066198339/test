package com.lk.javaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author by LiuKui
 * @date 2021/3/3.
 */
public class CardID {

    private String cardNum;
    public int Y;
    public int birDay, birYear, birMonth, dif, sex, day, month, year, city, area; //出生日 年 月，年龄，性别，现在日 月 年
    public String curr;
    public boolean z;

    public void setCardNum(String cardNum) {//换一个号码
        this.cardNum = cardNum;
    }

    public boolean lengthVerify() {//1 位数错误验证
        return this.cardNum.length() == 18;
    }

    public boolean charVerify() {//2 字符错误验证
        boolean A = true;
        char[] Arr = cardNum.toCharArray();//转化成字符数组
        //判断是否是数字
        for (int i = 0; i < cardNum.length(); i++) {
            if (Arr[i] - '0' < 0 || Arr[i] - '0' > 9) {
                A = false;
                break;
            }
        }
        //判断最后一维是否是X或x
        if (Arr[cardNum.length() - 1] == 'x' || Arr[cardNum.length() - 1] == 'X') {
            A = true;
        }
        return A;
    }

    public boolean placeVerify() {
        city = Integer.parseInt(cardNum.substring(2, 4));
        area = Integer.parseInt(cardNum.substring(4, 6));
        if ((area <= 0 || area > 50) && (city <= 0 || city > 50)) {
            System.out.println("城市区县编码错误");
            return false;
        }
        if (city <= 0 || city > 50) {
            System.out.println("城市编码错误");
            return false;
        }
        if (area <= 0 || area > 50) {
            System.out.println("区县编码错误");
            return false;
        }
        return true;
    }

    public boolean checkCodeVerify() {//3 校验码错误验证
        // 测试时请将每一轮的 i,ai,wi,sum 输出，避免出错，成功后不再输出
        String testNum = this.cardNum.substring(0, 17) + "0";//提取字符串中介于两个指定下标之间的字符
        int i, ai, wi, sum = 0;
        for (i = 18; i >= 1; i--) {
            ai = testNum.charAt(18 - i) - 48;
            wi = (int) Math.pow(2, i - 1) % 11;
            sum += ai * wi;
        }
        int mod = sum % 11;
        char[] last = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        System.out.println("正确的校验码为：" + last[mod]);
        return this.cardNum.toUpperCase().charAt(17) == last[mod];
    }

    public void output() {//4 信息输出
        //按要求输出个人信息
        birYear = Integer.parseInt(cardNum.substring(6, 10));
        birDay = Integer.parseInt(cardNum.substring(12, 14));
        birMonth = Integer.parseInt(cardNum.substring(10, 12));
        dif = Y - birYear;
        sex = Integer.parseInt(cardNum.substring(16, 17));

        Date crr = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        curr = sdf.format(crr);
        String[] D = curr.split("-");
        year = Integer.parseInt(D[0]);
        day = Integer.parseInt(D[2]);
        month = Integer.parseInt(D[1]);
        dif = year - birYear;
        if (month == birMonth && day < birDay) {
            dif--;
        }
        if (month < birMonth) {
            dif--;
        }

        System.out.println("出生日期为：" + birYear + "年" + birMonth + "月" + String.format("%02d", birDay) + "日");

        //出生日期字符串“1998-05-22”
        String bornData = cardNum.substring(6, 10) + "-" + cardNum.substring(10, 12) + "-" + cardNum.substring(12, 14);
//        //计算时间天数
//        String bornTime;

//        //月按30天算
//        System.out.println("你的年龄为：" + dif + "岁" + bornTime % 365 / 30 + "月" + bornTime % 365 % 30 + "天");
        try {
            System.out.println("你的年龄为：" + calTimeAgo(sdf.parse(bornData)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (sex % 2 == 1) {
            System.out.println("性别：男");
        } else {
            System.out.println("性别：女");
        }

    }

    public static String calTimeAgo(Date date) {
        Date nowDate = new Date();
//        if (date.after(nowDate)) {
//            return "0分钟前";
//        }
        //初始化calendar对象
        Calendar nowCal = Calendar.getInstance();
        Calendar dateCal = Calendar.getInstance();
        //获取当前和出生时间
        nowCal.setTime(nowDate);
        dateCal.setTime(date);

        //年龄
        int yearAgo = nowCal.get(Calendar.YEAR) - dateCal.get(Calendar.YEAR);
        //计算相差月份
        int monthAgo = nowCal.get(Calendar.MONTH) - dateCal.get(Calendar.MONTH);

        if (monthAgo < 0) {
            yearAgo--;
            monthAgo += 12;
        }
        int dayAgo = nowCal.get(Calendar.DAY_OF_MONTH) - dateCal.get(Calendar.DAY_OF_MONTH);
        if (dayAgo < 0) {
            monthAgo--;
            //获取当年某个月最大天数
            dayAgo += dateCal.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (monthAgo < 0) {
                yearAgo--;
                monthAgo += 12;
            }
        }
        if (dayAgo == 1) {
            return (yearAgo < 1 ? "" : (yearAgo + "岁"))
                    + (monthAgo < 1 ? "" : (monthAgo + "月")) +
                    (dayAgo < 1 ? "" : (dayAgo + "天")) + "\t" + "昨天过生！";
        }
        if (dayAgo == 0) {
            return (yearAgo < 1 ? "" : (yearAgo + "岁"))
                    + (monthAgo < 1 ? "" : (monthAgo + "月")) +
                    (dayAgo < 1 ? "" : (dayAgo + "天")) + "\t" + "今天过生！";
        }
//        if ( dayAgo ) {
//            return (yearAgo < 1 ? "" : (yearAgo + "岁"))
//                    + (monthAgo < 1 ? "" : (monthAgo + "月")) +
//                    (dayAgo < 1 ? "" : (dayAgo + "天")) + "\t" + "明天过生！";
//        }
        return (yearAgo < 1 ? "" : (yearAgo + "岁"))
                + (monthAgo < 1 ? "" : (monthAgo + "月")) +
                (dayAgo < 1 ? "" : (dayAgo + "天")) + "\t" + "还没过生！";
    }


    //通过天数计算
//    public static long calTimeAgo(String bornData) {
//        SimpleDateFormat s = new SimpleDateFormat("yyy-MM-dd");//字符串转换成date类型
//        Date d = null;
//        //异常处理
//        try {
//            d = s.parse(bornData);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Date now = new Date();//获取当前时间
//        long nowTime = now.getTime();//将当前date时间转换成毫秒
//        long bornTime = d.getTime();//将出生日期转换成毫秒
//        long time = nowTime - bornTime;//当前时间的毫秒减掉出生时间的毫秒就是活了多久的毫秒数
//        //根据毫秒判断出生与否，出生了就将毫秒时间转换成天数，一秒=一千毫秒，一分钟有60秒，一小时60分，一天24小时
//        return time / 1000 / 60 / 60 / 24;
//    }


}




