package com.paul623.android.wearos.tomatoclock;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    /**
     * 根据当前时间判断时间段
     * 0为凌晨
     * 1为上午
     * 以此类推
     */
    public static int getCurTimePart() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(date);
        int a = Integer.parseInt(str);
        if (a >= 0 && a <= 6) {
            //System.out.println("凌晨");
            return 0;
        } else if (a > 6 && a < 12) {
            //System.out.println("上午");
            return 1;
        } else if (a == 12) {
            //System.out.println("中午");
            return 2;
        } else if (a >= 13 && a < 18) {
            //System.out.println("下午");
            return 3;
        } else if (a >= 18 && a < 22) {
            //System.out.println("晚上");
            return 4;
        } else {
            return 5;
        }
    }
}
