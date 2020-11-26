package com.gaan.liver.util;

import java.util.TimeZone;

public class DateUtil {

    public static String getTimeZone(){
        String timezone = TimeZone.getDefault().getDisplayName();
        char symbol = timezone.charAt(0) == '+' ? '1' : '0';
        return timezone.substring(3).replace(timezone.charAt(0),symbol); // +04:00
    }


}
