package com.newplan.base.util;

import com.google.common.base.Preconditions;
import com.newplan.base.math.MathUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author JoeTwan
 * @date 2021/9/5 13:20
 * @description 日期格式化通用类
 */
@Log4j2
public class DateUtil {

    public static final long MILLIS_PER_SECOND = 1000L;
    public static final long MILLIS_PER_MINUTE = 60000L;
    public static final long MILLIS_PER_HOUR = 3600000L;
    public static final long MILLIS_PER_DAY = 86400000L;
    /**
     * 格式化实例
     */
    private static final FastDateFormat FORMATTER_4y2M2d = FastDateFormat.getInstance("yyyy-MM-dd");
    /**
     * 格式化实例
     */
    private static final FastDateFormat FORMATTER_4y2M2d2H2m2s = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    private static final Integer[] ARRAY_MONTH_NOT_LEAP_YEAR = new Integer[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final Integer[] ARRAY_MONTH_LEAP_YEAR = new Integer[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    /**
     * 比较date1 和 date2 的大小
     *
     * @param date1 date1
     * @param date2 date2
     * @return date1.getTime() - date2.getTime()
     */
    public static int compare(Date date1, Date date2) {
        Preconditions.checkNotNull(date1);
        Preconditions.checkNotNull(date2);
        return date1.compareTo(date2);
    }

    /**
     * 增加小时
     *
     * @param dateTime 起始时间点
     * @param hours    增加小时数，可负值
     * @return 结果
     */
    public static Date addHours(Date dateTime, int hours) {
        return DateUtils.addHours(dateTime, hours);
    }

    /**
     * 增加小时
     *
     * @param dateTime 起始时间点
     * @param hours    增加小时数，可负值
     * @return 结果
     */
    public static Date addHours(long dateTime, int hours) {
        return addHours(new Date(dateTime), hours);
    }

    /**
     * 加天数
     *
     * @param dateTime 时间参数
     * @param days     增加天数，可负值
     * @return 天数日期
     */
    public static Date addDays(Date dateTime, int days) {
        return DateUtils.addDays(dateTime, days);
    }

    /**
     * 加天数
     *
     * @param dateTime 时间参数
     * @param days     增加天数，可负值
     * @return 天数日期
     */
    public static Date addDays(long dateTime, int days) {
        return DateUtils.addDays(new Date(dateTime), days);
    }

    /**
     * 格式化时间字符串toDate
     *
     * @param sourceDateString 时间字符串
     * @return Date
     */
    public static Date timestampWith4y2M2d2H2m2s(String sourceDateString) {
        try {
            return FORMATTER_4y2M2d2H2m2s.parse(sourceDateString);
        } catch (ParseException e) {
            log.error("时间转换失败,sourceDateString={},exception={}", sourceDateString, e);
        }
        return null;
    }

    /**
     * 格式化时间字符串toDate
     *
     * @param sourceDateString 时间字符串
     * @return Date
     */
    public static Date timestampWith4y2M2d(String sourceDateString) {
        try {
            return FORMATTER_4y2M2d.parse(sourceDateString);
        } catch (ParseException e) {
            log.error("时间转换失败,sourceDateString={},exception={}", sourceDateString, e);
        }
        return null;
    }

    /**
     * 格式化时间戳
     *
     * @param dateTime 时间Date
     * @return 字符串时间
     */
    public static String format4y2M2d(Date dateTime) {
        return format4y2M2d(dateTime.getTime());
    }

    /**
     * 格式化时间戳
     *
     * @param dateTime 时间Date
     * @return 字符串时间
     */
    public static String format4y2M2d2H2m2s(Date dateTime) {
        return format4y2M2d2H2m2s(dateTime.getTime());
    }

    /**
     * 格式化时间戳
     *
     * @param timestamp 时间戳
     * @return 字符串时间
     */
    public static String format4y2M2d(Long timestamp) {
        return FORMATTER_4y2M2d.format(timestamp);
    }

    /**
     * 格式化时间戳
     *
     * @param timestamp 时间戳
     * @return 字符串时间
     */
    public static String format4y2M2d2H2m2s(long timestamp) {
        return FORMATTER_4y2M2d2H2m2s.format(timestamp);
    }

    /**
     * 一年中的第几天
     *
     * @param date 时间
     * @return 第几天
     */
    public static Integer dayOfYear(Date date) {
        Integer[] monthArray = adaptMonthArray(getYear(date));
        int days = 0;
        for (int i = 0; i < getMonth(date) - 1; ++i) {
            days += monthArray[i];
        }
        days += getDayOfMonth(date);
        return days;
    }

    /**
     * 一年中的第几周
     *
     * @param date 时间
     * @return 第几周
     */
    public static Integer weekOfYear(Date date) {
        return buildCalendar(date).get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取年份对应的月份列表
     *
     * @param year 年份
     * @return 月份列表
     */
    private static Integer[] adaptMonthArray(int year) {
        return isLeapYear(year) ? ARRAY_MONTH_LEAP_YEAR : ARRAY_MONTH_NOT_LEAP_YEAR;
    }

    /**
     * 获取时间年份
     *
     * @param date 时间
     * @return 年份
     */
    public static Integer getYear(Date date) {
        return buildCalendar(date).get(Calendar.YEAR);
    }

    /**
     * 获取时间月份
     *
     * @param date 时间
     * @return 月份
     */
    private static Integer getMonth(Date date) {
        return buildCalendar(date).get(Calendar.MONTH);
    }

    /**
     * 获取一周的第几天
     *
     * @param date 时间
     * @return 一周的第几天
     */
    public static Integer getDayOfWeek(Date date) {
        return buildCalendar(date).get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取一月中的第几天
     *
     * @param date 时间
     * @return 月天数
     */
    public static Integer getDayOfMonth(Date date) {
        return buildCalendar(date).get(Calendar.DAY_OF_MONTH);
    }

    /**
     * long 转换Calendar
     *
     * @param timestamp 时间戳
     * @return 转换结果
     */
    public static Calendar buildCalendar(long timestamp) {
        return buildCalendar(new Date(timestamp));
    }

    /**
     * Date 转换 Calendar
     *
     * @param dateTime 时间戳
     * @return 转换结果
     */
    public static Calendar buildCalendar(Date dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);

        return calendar;
    }

    /**
     * 闰年判断
     *
     * @param year 年份
     * @return 是否为闰年
     */
    public static boolean isLeapYear(Integer year) {
        return MathUtil.isPositive(year) && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }



}
