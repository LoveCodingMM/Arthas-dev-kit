package com.ai.cloud.arthas.orm.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 18:47
 * @description DateUtils2
 */
public final class DateUtils2 {

    private static DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static DateTimeFormatter LONG_STYLE_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 默认，如2011-12-03
     */
    private static DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private static DateTimeFormatter LONG_STYLE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static DateTimeFormatter LONG_STYLE_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");

    private static DateTimeFormatter CN_MONTH_FORMATTER = DateTimeFormatter.ofPattern("M月d日 HH:mm");

    private static DateTimeFormatter LONG_STYLE_MILLIS_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    private static DateTimeFormatter UTC_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private static DateTimeFormatter UTC_TIME_MILLIS_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public static final int DAY_SECONDS = 24 * 60 * 60;

    private DateUtils2() {
    }

    ////////////////////////////// 整型日期 ///////////////////////////////////

    public static int getTodayInt() {
        return Integer.parseInt(getLongStyleDateString(new Date()));
    }

    public static int getDateInt(Date date) {
        return Integer.parseInt(getLongStyleDateString(date));
    }

    public static int getMonthInt() {
        return getMonthInt(new Date());
    }

    public static int getMonthInt(Date date) {
        String format = asLocalDate(date).format(LONG_STYLE_MONTH_FORMATTER);
        return Integer.parseInt(format);
    }

    public static int getLastMonthInt() {
        LocalDate date = asLocalDate(new Date());
        LocalDate lastDate = date.minusMonths(1);
        String format = lastDate.format(LONG_STYLE_MONTH_FORMATTER);
        return Integer.parseInt(format);
    }

    public static int getYesterdayInt() {
        LocalDate localDate = asLocalDate(new Date()).minusDays(1);
        return Integer.parseInt(localDate.format(LONG_STYLE_DATE_FORMATTER));
    }

    public static int getSomeDate(int baseDateInt, int delta) {
        String date = asLocalDateTime(getLongStyleDate(String.valueOf(baseDateInt)))
                .plusDays(delta)
                .format(LONG_STYLE_DATE_FORMATTER);
        return Integer.parseInt(date);
    }

    //////////////////////////// Date /////////////////////////////////

    public static Date getDefaultDate(String value) {
        return asDate(LocalDate.parse(value, DEFAULT_DATE_FORMATTER));
    }

    public static Date getLongStyleDate(String yyyyMMdd) {
        return asDate(LocalDate.parse(yyyyMMdd, LONG_STYLE_DATE_FORMATTER));
    }

    public static Date getDefaultDateTime(String value) {
        return asDate(LocalDateTime.parse(value, DEFAULT_DATETIME_FORMATTER));
    }

    public static Date getLongStyleDateTime(String yyyyMMddHHmmss) {
        return asDate(LocalDateTime.parse(yyyyMMddHHmmss, LONG_STYLE_DATETIME_FORMATTER));
    }

    /**
     * 不考虑时区，只是字符串格式转换
     * @param utcTimeStr
     * @return
     */
    public static Date getUtcDateTime(String utcTimeStr) {
        return asDate(LocalDateTime.parse(utcTimeStr, UTC_TIME_FORMATTER));
    }

    public static Date getSomeDate(Date base, int delta) {
        return asDate(asLocalDateTime(base).plusDays(delta));
    }

    public static Date deltaMinutes(Date base, int minutes) {
        return asDate(asLocalDateTime(base).plusMinutes(minutes));
    }

    public static Date deltaSeconds(Date base, long seconds) {
        return asDate(asLocalDateTime(base).plusSeconds(seconds));
    }

    public static Date deltaDays(Date base, long days) {
        return asDate(asLocalDateTime(base).plusDays(days));
    }

    public static Date deltaHours(Date base, long hours) {
        return asDate(asLocalDateTime(base).plusHours(hours));
    }

    //////////////////////////// String ///////////////////////////

    public static String getDefaultDateString(Date value) {
        return asLocalDate(value).format(DEFAULT_DATE_FORMATTER);
    }

    public static String getLongStyleDateString(Date value) {
        return asLocalDate(value).format(LONG_STYLE_DATE_FORMATTER);
    }

    public static String getDefaultDateTimeString(Date value) {
        return asLocalDateTime(value).format(DEFAULT_DATETIME_FORMATTER);
    }

    public static String getLongStyleDateTimeString(Date date) {
        return asLocalDateTime(date).format(LONG_STYLE_DATETIME_FORMATTER);
    }

    public static String getLongStyleMillisString(Date date) {
        return asLocalDateTime(date).format(LONG_STYLE_MILLIS_FORMATTER);
    }

    /**
     * 不考虑时区，只是格式转换
     * @param date
     * @return
     */
    public static String getUtcString(Date date) {
        return asLocalDateTime(date).format(UTC_TIME_FORMATTER);
    }

    //////////////////////////// 其他工具 //////////////////////////////

    /**
     * 获取2个日期之间相差的天数，若start日期在end之后，则返回负数
     * @param start
     * @param end
     * @return
     */
    public static long getDaysBetween(Date start, Date end) {
        return Duration.between(asLocalDate(start).atStartOfDay(), asLocalDate(end).atStartOfDay()).toDays();
    }

    public static long getHoursBetween(Date start, Date end) {
        return Duration.between(asLocalDateTime(start), asLocalDateTime(end)).toHours();
    }

    public static long getSecondsBetween(Date start, Date end) {
        return Duration.between(asLocalDateTime(start), asLocalDateTime(end)).getSeconds();
    }

    /**
     * 获取2个日期之间相差的月份数，若start日期在end日期之后，则返回负数，完全忽略日期因素，如20190201和20190331，相差月份仍然为1
     * @param start
     * @param end
     * @return
     */
    public static long getMonthsBetween(Date start, Date end) {
        return ChronoUnit.MONTHS.between(asLocalDate(start).withDayOfMonth(1), asLocalDate(end).withDayOfMonth(1));
    }

    public static Date getStartOfDay(Date date) {
        return asDate(asLocalDateTime(date).with(LocalTime.MIN));
    }

    public static Date getEndOfDay(Date date) {
        return asDate(asLocalDateTime(date).with(LocalTime.MAX));
    }

    public static Date getFirstDayOfMonth(Date date) {
        return asDate(asLocalDate(date).with(TemporalAdjusters.firstDayOfMonth()));
    }

    public static Date getLastDayOfMonth(Date date) {
        return asDate(asLocalDate(date).with(TemporalAdjusters.lastDayOfMonth()));
    }

    public static Date getWeekStart(Date date) {
        if (asLocalDate(date).getDayOfWeek() == DayOfWeek.MONDAY) {
            return getStartOfDay(date);
        }
        return asDate(asLocalDate(date).with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
    }

//    /**
//     * 返回当天零点
//     * @param date
//     * @return
//     */
//    public static Date getCurrentDate(Date date) {
//        return asDate(asLocalDateTime(date).with(LocalTime.MIN));
//    }

    public static String formatByCnMonth(Date date) {
        return asLocalDateTime(date).format(CN_MONTH_FORMATTER);
    }

    public static List<String> genMonthsClosedBetween(long start, long end, int stepSize) {
        List<String> months = new ArrayList<>();
        YearMonth endMonth = YearMonth.parse(String.valueOf(end), LONG_STYLE_DATE_FORMATTER);
        for (YearMonth month = YearMonth.parse(String.valueOf(start), LONG_STYLE_DATE_FORMATTER);
             !month.isAfter(endMonth);
             month = month.plusMonths(stepSize)) {
            months.add(month.format(LONG_STYLE_MONTH_FORMATTER));
        }
        return months;
    }

    /**
     * gmtOffset是gmtDefaultDt（yyyy-MM-dd HH:mm:ss）所在的时区
     * @param gmtDefaultDt
     * @param gmtOffset
     * @return
     */
    public static Date toUtcDateTime(String gmtDefaultDt, String gmtOffset) {
        ZonedDateTime gmtZdt = LocalDateTime.parse(gmtDefaultDt, DEFAULT_DATETIME_FORMATTER)
                .atZone(ZoneId.ofOffset("GMT", ZoneOffset.of(gmtOffset)));
        // 0时区
        ZonedDateTime utcZdt = gmtZdt.withZoneSameInstant(ZoneId.of("UTC"));
        return asDate(utcZdt.toLocalDateTime());
    }

    /**
     * gmtOffset是返回结果所在的时区
     * @param utcTimeString
     * @return
     */
    public static Date toGmt8DateTime(String utcTimeString) {
        return toGmtDateTime(utcTimeString, "+8");
    }

    /**
     * gmtOffset是返回结果所在的时区
     * @param utcTimeString
     * @param gmtOffset
     * @return
     */
    public static Date toGmtDateTime(String utcTimeString, String gmtOffset) {
        ZonedDateTime gmtZdt = LocalDateTime.parse(utcTimeString, UTC_TIME_FORMATTER).atZone(ZoneId.of("UTC"));
        // 0时区
        ZonedDateTime utcZdt = gmtZdt.withZoneSameInstant(ZoneId.ofOffset("GMT", ZoneOffset.of(gmtOffset)));
        return asDate(utcZdt.toLocalDateTime());
    }

    /**
     * gmtOffset是返回结果所在的时区
     * @param utcMillisString
     * @param gmtOffset
     * @return
     */
    public static Date toGmtDateTimeMillis(String utcMillisString, String gmtOffset) {
        ZonedDateTime gmtZdt = LocalDateTime.parse(utcMillisString, UTC_TIME_MILLIS_FORMATTER).atZone(ZoneId.of("UTC"));
        // 0时区
        ZonedDateTime utcZdt = gmtZdt.withZoneSameInstant(ZoneId.ofOffset("GMT", ZoneOffset.of(gmtOffset)));
        return asDate(utcZdt.toLocalDateTime());
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss格式的字符串转为Date
     *
     * @param value 字符串日期
     * @return 时间
     */
    public static Date asDate(String value) {
        return Date.from(asLocalDateTime(value).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将yyyy-MM-dd格式的字符串转为Date
     *
     * @param value 字符串日期
     * @return 本地日期
     */
    public static LocalDate asLocalDate(String value) {
        return LocalDate.parse(value, DEFAULT_DATE_FORMATTER);
    }

    public static LocalTime asLocalTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss格式的字符串转为Date
     *
     * @param value 字符串日期
     * @return 本地时间
     */
    public static LocalDateTime asLocalDateTime(String value) {
        return LocalDateTime.parse(value, DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * 转秒到HH:MM
     *
     * @param second 秒数
     * @return HH:MM
     */
    public static String formatHHmm(Integer second) {
        if (null == second) {
            return null;
        }

        Integer h = second / 3600;
        Integer m = second % 3600 / 60;
        return String.format("%02d:%02d", h, m);
    }
}

