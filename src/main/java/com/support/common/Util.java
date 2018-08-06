package com.support.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Util {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public static Date parseDate(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }
    
    public static String formatDate(Date date) {
        return sdf.format(date);
    }
    
    public static List<Date> calculateWorkingDates(Date date, int interval) {
        List<Date> workingDates = new ArrayList<>(); 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        for (int i=0; i<interval;) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if(calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY) {
                workingDates.add(calendar.getTime());
                i++;
            }
        }
        return workingDates;
    }
    
    public static int getRandomNumber(int max) {
        Random ran = new Random();
        return ran.nextInt(max);
    }

}
