package com.lz.util.date;

import com.lz.util.file.CommUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间的转换
 * @Author 孙阳阳
 * @Date 2019/10/9
 **/
public class DateUtil implements Serializable {
    private static final long serialVersionUID = 1L;

    private static String[] formatList = new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd","yyyy-mm-dd","yyyy/MM/dd HH:mm:ss","yyyy/MM/dd","yyyy/mm/dd",
            "yyyyMMdd HH:mm:ss","yyyyMMdd","yyyymmdd","yyyy年mm月dd HH时mm分ss秒","yyyy年mm月dd日"};
    /**
     * 获取当前时间的指定格式字符串,默认值:yyyy-MM-dd HH:mm:ss
     * */
    public static String getCurrentTime(String format){
        if(!CommUtils.isNotEmpty(format))
            format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 获取当前月的天数
     * */
    public static int getCurrentDay(){
        return getCurrentDay(new Date());
    }

    /**
     * 获取指定日期中月的天数
     * */
    public static int getCurrentDay(Date date){
        if(date==null)
            return 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前月的总天数
     * */
    public static int getCurrentDays(){
        return getCurrentDays(new Date());
    }

    /**
     * 获取指定日期中月的总天数
     * */
    public static int getCurrentDays(Date date){
        if(date==null)
            return 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);  //把日期设置为当月第一天
        calendar.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取指定日期中月的总天数
     * */
    public static int getMonthInDays(String dateStr,String format) throws ParseException {
        if(dateStr==null)
            return 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strFormat(dateStr,format));
        calendar.set(Calendar.DATE, 1);  //把日期设置为当月第一天
        calendar.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        return calendar.get(Calendar.DATE);
    }

    /**
     * 将日期类型格式化为指定格式字符串
     * */
    public static String dateFormat(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将未知格式的日期字符串格式化为指定格式字符串
     * */
    public static String dateFormat(String dateStr,String format) throws ParseException{
        return dateFormat(strFormat(dateStr, patternFormat(dateStr)), format);
    }

    /**
     * 将日期字符串转化为日期类型(格式:yyyy-MM-dd HH:mm:ss)
     * */
    public static Date strFormat(String dateStr) throws ParseException{

        return strFormat(dateStr,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期字符串转化为日期类型
     * */
    public static Date strFormat(String dateStr,String format) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

    /**
     * 判断日期是否为指定格式
     * */
    public static boolean patternFormat(String dateStr,String format){

        if(!CommUtils.isNotEmpty(dateStr))
            return false;
        if(!CommUtils.isNotEmpty(format))
            return false;

        return CommUtils.equalsIgnoreCase(format,patternFormat(dateStr));
    }

    /***
     *判定日期字符串的格式,目前支持判定:yyyy-MM-dd HH:mm:ss,yyyy-MM-dd,yyyy-mm-dd,yyyy/MM/dd HH:mm:ss,yyyy/MM/dd,yyyy/mm/dd,
     *                 yyyyMMdd HH:mm:ss,yyyyMMdd,yyyymmdd,yyyy年mm月dd日,yyyy年mm月dd HH时mm分ss秒
     */
    public static String patternFormat(String dateStr){
        if(!CommUtils.isNotEmpty(dateStr))
            return "";

        SimpleDateFormat sdf;
        for(String format : formatList){
            sdf = new SimpleDateFormat(format);
            try {
                sdf.parse(dateStr);
                if(format.length()==dateStr.length())
                    return format;
            }catch (Exception e){ }
        }
        return "";
    }

    /**
     * 当前日期与指定日期之间相隔天数(得到的天数中开始日期与结束日期未计算在内)
     * @param date
     * 			日期
     * */
    public static int twoDateDiff(String date) throws ParseException{
        Date date1 = new Date();
        Date date2 = strFormat(date, "yyyy-MM-dd");
        return twoDateDiff(date1,date2,Calendar.DATE);
    }

    /**
     * 两个日期时间之间相隔天数(得到的天数中开始日期与结束日期未计算在内)
     * @param firstStr
     * 			开始日期字符串,格式:yyyy-MM-dd HH:mm:ss
     * @param secondStr
     * 			结束日期字符串,格式:yyyy-MM-dd HH:mm:ss
     * */
    public static int twoDateDiff(String firstStr,String secondStr,int type) throws ParseException {
        return twoDateDiff(strFormat(firstStr,"yyyy-MM-dd HH:mm:ss"),strFormat(secondStr,"yyyy-MM-dd HH:mm:ss"),type);
    }

    /**
     * 两个日期之间相隔天数(得到的天数中少一天)
     * @param firstStr
     * 			开始日期字符串,格式:yyyy-MM-dd
     * @param secondStr
     * 			结束日期字符串,格式:yyyy-MM-dd
     * */
    public static int twoDateDiff(String firstStr,String secondStr) throws ParseException {
        return twoDateDiff(strFormat(firstStr,"yyyy-MM-dd"),strFormat(secondStr,"yyyy-MM-dd"),Calendar.DATE);
    }

    /**
     * 两个时间之间相减(算出的值少一天,两个日期相同除外)
     * @param first
     * 			开始时间
     * @param second
     * 			结束时间
     * */
    public static int twoDateDiff(Date first,Date second){
        return twoDateDiff(first,second,Calendar.DATE);
    }

    /**
     * 两个时间之间相减
     * @param first
     * 			开始时间
     * @param second
     * 			结束时间
     * */
    public static int twoDateDiff(Date first,Date second,int type){
        if(type==Calendar.DATE)
            return Integer.parseInt(((second.getTime()-first.getTime())/(1000*60*60*24))+"");
        else if(type==Calendar.HOUR)
            return Integer.parseInt(((second.getTime()-first.getTime())/(1000*60*60))+"");
        else if(type==Calendar.MINUTE)
            return Integer.parseInt(((second.getTime()-first.getTime())/(1000*60))+"");
        else if(type==Calendar.SECOND)
            return Integer.parseInt(((second.getTime()-first.getTime())/(1000))+"");
        else
            return Integer.parseInt(((second.getTime()-first.getTime()))+"");
    }

    /**
     * 获取当前日期与指定天数之间的日期列表
     *
     * */
    public static String[] getDateList(int day){

        return getDateList(new Date(),day);
    }

    /**
     * 获取当前日期与指定天数之间的日期列表
     * @param startDateStr
     *          开始日期字符串,格式:yyyy-MM-dd
     * */
    public static String[] getDateList(String startDateStr,int day) throws ParseException {

        return getDateList(strFormat(startDateStr,"yyyy-MM-dd"),day);
    }

    /**
     * 获取当前日期与指定天数之间的日期列表
     *
     * */
    public static String[] getDateList(Date startDate,int day){
        String [] dateList = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        if(day<0){
            calendar.add(Calendar.DATE, day+1);
            day = -day;
            dateList = new String[day];
        }else
            dateList = new String[day];


        for(int i=0;i<day;i++){
            calendar.add(Calendar.DATE, i);
            dateList[i]=dateFormat(calendar.getTime(), "yyyy-MM-dd");
            calendar.add(Calendar.DATE, -i);
        }
        return dateList;
    }

    public static void main(String[] args) throws ParseException {
        //System.out.println(getCurrentDay());
        String first = "2018-10-31";
        String second = "2018-10-31";
        System.out.println(twoDateDiff(strFormat(first,"yyyy-MM-dd"),strFormat(second,"yyyy-MM-dd")));
        first = "2018-10-31 12:22:12";
        second = "2018-10-31 12:30:13";
        System.out.println(twoDateDiff(first,second,Calendar.SECOND));
        System.out.println(CommUtils.doubleFormat(33.345));
        for(String str:getDateList(strFormat("2019-12-31","yyyy-MM-dd"),1))
            System.out.println(str);
    }
}
