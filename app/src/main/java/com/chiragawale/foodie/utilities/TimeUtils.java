package com.chiragawale.foodie.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtils {

    public static String getFormatedDate(long date) {
        try {
            Date d = new Date(date);
            SimpleDateFormat f = new SimpleDateFormat("EEEE, MMM dd, yyyy");
            f.setTimeZone(TimeZone.getTimeZone("UTC"));
            return f.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "N/A";
    }

    public static String getFormatedDateWithTime(long date) {
        Date d = new Date(date);
        SimpleDateFormat dateformat = new SimpleDateFormat("EEE dd, MMMM yyyy , hh:mm aa");
        return dateformat.format(d);
    }

    public static String formatDateTZ(long date) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        return dateformat.format(date);
    }

    public static String getFormatedDate(String stringDate, String pattern) {
        try {
            SimpleDateFormat sf = new SimpleDateFormat(pattern, Locale.getDefault());
            sf.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = sf.parse(stringDate);
            return getFormatedDate(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }


    public static String currentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("EEE dd, MMMM yyyy");
        String datetime = dateformat.format(c.getTime());
        return datetime;
    }

    public static long currentDateLong() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            c.setTime(dateformat.parse(currentDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.getTimeInMillis();
    }

    public static String formatDate(long date) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = dateformat.format(date);
        return datetime;
    }

    public static String formatDate(long date, String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        String datetime = dateformat.format(date);
        return datetime;
    }


    public static long getTrimmedDate(String date) {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            return dateformat.parse(date).getTime();
        } catch (Exception e) {

        }
        return 0;
    }

    public static long getTrimmedDate(long date) {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = formatDate(date);
            return dateformat.parse(stringDate).getTime();
        } catch (Exception e) {

        }
        return 0;
    }

    public static long getDate(int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH,days);
        return getTrimmedDate(cal.getTimeInMillis());
    }

}
