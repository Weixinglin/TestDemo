package com.xiaolai.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/2 19:12
 **/
public class DateUtils {

    /**
     * 日期类型转换自定义格式的字符串
     * @param date
     * @return
     */
    public static String DateToString(Date date,String pattern){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }


    /**
     * 字符串转日期类型
     * @param str
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String str,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(str);
        return date;
    }
}
