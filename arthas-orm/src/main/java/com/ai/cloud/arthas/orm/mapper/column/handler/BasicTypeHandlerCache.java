package com.ai.cloud.arthas.orm.mapper.column.handler;

import com.ai.cloud.arthas.orm.utils.DateUtils2;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 17:02
 * @description BasicTypeHandlerCache
 */
public class BasicTypeHandlerCache {

    private static final DbTypeHandler<Boolean> BOOLEAN = new DbTypeHandler<Boolean>() {
        @Override
        public Boolean transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, Boolean.class);
        }

        @Override
        public Boolean transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, Boolean.class);
        }
    };

    private static final DbTypeHandler<Byte> BYTE = new DbTypeHandler<Byte>() {
        @Override
        public Byte transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, Byte.class);
        }

        @Override
        public Byte transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, Byte.class);
        }
    };

    private static final DbTypeHandler<Short> SHORT = new DbTypeHandler<Short>() {
        @Override
        public Short transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, Short.class);
        }

        @Override
        public Short transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, Short.class);
        }
    };

    private static final DbTypeHandler<Integer> INTEGER = new DbTypeHandler<Integer>() {
        @Override
        public Integer transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, Integer.class);
        }

        @Override
        public Integer transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, Integer.class);
        }
    };

    private static final DbTypeHandler<Long> LONG = new DbTypeHandler<Long>() {
        @Override
        public Long transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, Long.class);
        }

        @Override
        public Long transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, Long.class);
        }
    };

    private static final DbTypeHandler<Float> FLOAT = new DbTypeHandler<Float>() {
        @Override
        public Float transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, Float.class);
        }

        @Override
        public Float transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, Float.class);
        }
    };

    private static final DbTypeHandler<Double> DOUBLE = new DbTypeHandler<Double>() {
        @Override
        public Double transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, Double.class);
        }

        @Override
        public Double transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, Double.class);
        }
    };

    private static final DbTypeHandler<BigDecimal> BIG_DECIMAL = new DbTypeHandler<BigDecimal>() {
        @Override
        public BigDecimal transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, BigDecimal.class);
        }

        @Override
        public BigDecimal transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, BigDecimal.class);
        }
    };

    private static final DbTypeHandler<String> STRING = new DbTypeHandler<>() {
        @Override
        public String transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getObject(index, String.class);
        }

        @Override
        public String transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getObject(label, String.class);
        }
    };

    private static final DbTypeHandler<URL> URL_FETCHER = new DbTypeHandler<URL>() {
        @Override
        public URL transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getURL(index);
        }

        @Override
        public URL transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getURL(label);
        }
    };

    private static final DbTypeHandler<Date> DATE = new DbTypeHandler<Date>() {
        @Override
        public Date transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getTimestamp(index);
        }

        @Override
        public Date transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getTimestamp(label);
        }
    };

    private static final DbTypeHandler<Timestamp> TIME_STAMP = new DbTypeHandler<Timestamp>() {
        @Override
        public Timestamp transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getTimestamp(index);
        }

        @Override
        public Timestamp transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getTimestamp(label);
        }
    };

    private static final DbTypeHandler<LocalDate> LOCAL_DATE = new DbTypeHandler<LocalDate>() {
        @Override
        public LocalDate transfer2Java(ResultSet rs, int index) throws SQLException {
            Date date = rs.getDate(index);
            return transfer(date);
        }

        @Override
        public LocalDate transfer2Java(ResultSet rs, String label) throws SQLException {
            Date date = rs.getDate(label);
            return transfer(date);
        }

        private LocalDate transfer(Date date) {
            if (date == null) {
                return null;
            }
            return DateUtils2.asLocalDate(date);
        }
    };

    private static final DbTypeHandler<LocalTime> LOCAL_TIME = new DbTypeHandler<LocalTime>() {
        @Override
        public LocalTime transfer2Java(ResultSet rs, int index) throws SQLException {
            Date date = rs.getDate(index);
            return transfer(date);
        }

        @Override
        public LocalTime transfer2Java(ResultSet rs, String label) throws SQLException {
            Date date = rs.getDate(label);
            return transfer(date);
        }

        private LocalTime transfer(Date date) {
            if (date == null) {
                return null;
            }
            return DateUtils2.asLocalTime(date);
        }
    };

    private static final DbTypeHandler<LocalDateTime> LOCAL_DATE_TIME = new DbTypeHandler<LocalDateTime>() {
        @Override
        public LocalDateTime transfer2Java(ResultSet rs, int index) throws SQLException {
            Date date = rs.getDate(index);
            return transfer(date);
        }

        @Override
        public LocalDateTime transfer2Java(ResultSet rs, String label) throws SQLException {
            Date date = rs.getDate(label);
            return transfer(date);
        }

        private LocalDateTime transfer(Date date) {
            if (date == null) {
                return null;
            }
            return DateUtils2.asLocalDateTime(date);
        }
    };

    private static final DbTypeHandler<byte[]> BYTE_ARRAY = new DbTypeHandler<byte[]>() {
        @Override
        public byte[] transfer2Java(ResultSet rs, int index) throws SQLException {
            return rs.getBytes(index);
        }

        @Override
        public byte[] transfer2Java(ResultSet rs, String label) throws SQLException {
            return rs.getBytes(label);
        }
    };

    @SuppressWarnings("rawtypes")
    private static final Map<Class<?>, DbTypeHandler> TYPE_MAP = new HashMap<>(16);

    static {
        TYPE_MAP.put(Boolean.class, BOOLEAN);
        TYPE_MAP.put(Boolean.TYPE, BOOLEAN);
        TYPE_MAP.put(Byte.class, BYTE);
        TYPE_MAP.put(Byte.TYPE, BYTE);
        TYPE_MAP.put(Short.class, SHORT);
        TYPE_MAP.put(Short.TYPE, SHORT);
        TYPE_MAP.put(Integer.class, INTEGER);
        TYPE_MAP.put(Integer.TYPE, INTEGER);
        TYPE_MAP.put(Long.class, LONG);
        TYPE_MAP.put(Long.TYPE, LONG);
        TYPE_MAP.put(Float.class, FLOAT);
        TYPE_MAP.put(Float.TYPE, FLOAT);
        TYPE_MAP.put(Double.class, DOUBLE);
        TYPE_MAP.put(Double.TYPE, DOUBLE);
        TYPE_MAP.put(BigDecimal.class, BIG_DECIMAL);
        TYPE_MAP.put(String.class, STRING);
        TYPE_MAP.put(URL.class, URL_FETCHER);
        TYPE_MAP.put(Date.class, DATE);
        TYPE_MAP.put(Timestamp.class, TIME_STAMP);
        TYPE_MAP.put(LocalDate.class, LOCAL_DATE);
        TYPE_MAP.put(LocalTime.class, LOCAL_TIME);
        TYPE_MAP.put(LocalDateTime.class, LOCAL_DATE_TIME);
        TYPE_MAP.put(byte[].class, BYTE_ARRAY);
    }

    @SuppressWarnings("unchecked")
    public static <T> DbTypeHandler<T> get(Class<T> type) {
        return TYPE_MAP.get(type);
    }

    public Boolean isBasicType(Class<?> clazz) {
        return TYPE_MAP.containsKey(clazz);
    }
}
