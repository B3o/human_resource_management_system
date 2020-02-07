package com.bemore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bmo
 * @date 2020/2/6 13:38
 * 返回格式化的当前日期
 */
public class DateUtil {
    public static Date getDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(sdf.format(date));
    }
}
