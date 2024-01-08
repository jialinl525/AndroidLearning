package com.jialin.recorder.util;


import java.util.Calendar;

public class SuperDateUtil {
    public static Integer currentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
//        return Calendar.getInstance().get(Calendar.MONTH);
    }
}
