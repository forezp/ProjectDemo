package com.forezp.open.utils;


import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间操作类、各种时间转换
 * Created by b508a on 2015/12/28.
 */
public class DateUtils {

    /**
     * 字符串转换成date 对象
     * @param dateString
     * @return
     */
    public static Date Convert2Date(String dateString)
    {
        return Convert2Date(dateString,"yyyy-MM-dd");
    }

    /**
     * 字符串 转date
     * @param dateString
     * @param type
     * @return
     */
    public static Date Convert2Date(String dateString, String type) {
        if (dateString == null || dateString.trim().equals("") || dateString.trim().equals("null"))
            return null;
        DateFormat df = new SimpleDateFormat(type);
        Date date = new Date();
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block\
            Log.e("StringToDate", dateString + "    " + e);
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 转出dateforamt
     * @param dateString
     * @param oldtype
     * @param newtype
     * @return
     */
    public static String changeFormat(String dateString, String oldtype,String newtype ) {
        if (dateString == null || dateString.trim().equals("") || dateString.trim().equals("null"))
            return "";
        DateFormat df = new SimpleDateFormat(oldtype);
        Date date = new Date();
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block\
            Log.e("StringToDate", dateString + "    " + e);
            e.printStackTrace();
        }
        return Date2String(date, newtype);
    }

    /**
     * 将date对象转换成String
     * @param date
     * @param format
     * @return
     */
    public static String Date2String(Date date,String format){
        SimpleDateFormat dateformat=new SimpleDateFormat(format);
        return dateformat.format(date);
    }

    /**
     * calendar  转String
     * @param date
     * @param format
     * @return
     */
    public static String Date2String(Calendar date,String format){
        SimpleDateFormat dateformat=new SimpleDateFormat(format);
        return dateformat.format(date.getTime());
    }

    /**
     * 获取00:12:25 格式的时间字符串
     * @param lenth
     * @return
     */
    public static String initProgramLength(int lenth) {
        int lengh = lenth;
        int hour = lengh / 3600;
        int min = lengh % 3600 / 60;
        int sec = lengh % 60;
        String programLength = null;
        if (hour == 0)
            programLength = "时长" + min + ":" + sec;
        else
            programLength = "时长 " + hour + ":" + min + ":" + sec;
        return programLength;
    }


    /**
     * 根据utc返回 hh:mm
     * @param UTCTime
     * @return 00:00这样的 小时：分
     */
    public static String getLocalTimeFromUTC(long UTCTime) {
        String result;

        Date d = new Date(UTCTime);
        Calendar cal=Calendar.getInstance();
        cal.setTime(d);
        int hour=   cal.get(Calendar.HOUR_OF_DAY);
        int min=cal.get(Calendar.MINUTE);
        String hourstr;
        String minStr;
        if(hour<10){
            hourstr="0"+hour;
        }
        else{
            hourstr=""+hour;
        }
        if(min<10){
            minStr="0"+min;
        }
        else{
            minStr=""+min;
        }
        result = hourstr + ":" + minStr;
        return result;
    }
    /**
     * 将utc转换成calendar
     */

    public static Calendar getCalendarFromUTC(long UTCTime) {
        Date d = new Date(UTCTime);
        Calendar cal=Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }
    /**
     *
     * @param UTCTime
     * @return yyyy-mm--dd
     */
    public static String getDateFromUtc(long UTCTime){


        Date d = new Date(UTCTime);
        Calendar cal=Calendar.getInstance();
        cal.setTime(d);
        //str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(cal.getTime());
        return (new SimpleDateFormat("yyyy-MM-dd ")).format(cal.getTime());
    }



    /**
     *
     * @param UTCTime
     * @return 上午 -下午-晚上  1-2-3
     */
    public static int getDayFiled(long UTCTime){


        Date d = new Date(UTCTime);
        Calendar cal=Calendar.getInstance();
        cal.setTime(d);
        int hour=   cal.get(Calendar.HOUR_OF_DAY);
        if(hour<12){
            return 1;//上午
        }
        if(hour<18){
            return 2;//下午
        }else{
            return 3;//晚上
        }
    }
    /**
     *
     * @param UTCTime
     * @return 星期几
     */
    //根据UTCTime  获取星期几
    public static String getWeekOfDateByUtc(long UTCTime) {
        Date d = new Date();
        d.setTime(UTCTime);
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return weekOfDays[w];
    }


    /**
     *
     * @param UTCTime
     * @return 星期几
     */
    //根据UTCTime  获取星期几
    public static String getWeekOfDateByUtc2(long UTCTime) {
        Date d = new Date();
        d.setTime(UTCTime);
        String[] weekOfDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return weekOfDays[w];
    }



    /**
     * 判断当前日期是星期几<br>
     * <br>
     * @param pTime 要判断的时间<br>
     * @return dayForWeek 判断结果<br>
     * @Exception 发生异常<br>
     */
    public static String getDayForWeekByStr(String pTime) throws Exception {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));

        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return weekOfDays[dayForWeek];
    }

    /**
     * 根据字符串获取utc
     * @param pTime 2015-12-12 12：12
     * @return  utc
     */
    public static long getUtcFromStamp(String pTime){
        //设定时间的模板
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到指定模范的时间

        Date d = null;
        try {
            d = sdf.parse(pTime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  d.getTime();
    }


    /**
     * s1是否大于s2
     * @param s1
     * @param s2
     * @return
     * @throws Exception
     */
    public static boolean DateCompare(String s1,String s2) throws Exception {
        //设定时间的模板
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到指定模范的时间
        Date d1 = sdf.parse(s1);
        Date d2 = sdf.parse(s2);
        if(d1.getTime() - d2.getTime()>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 获取今天0点的时间戳。
     * @return
     */

    public static long getToday0Mills(){
        Calendar c=Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.MILLISECOND, 001);
        return c.getTimeInMillis();
    }


}
