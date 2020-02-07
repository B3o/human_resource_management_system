package com.bemore.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Bmo
 * @date 2020/2/6 13:42
 * 将日期转化，使之能够在easyUI中的datagrid中正常显示
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
    private String format = "yyyy-MM-dd";

    public JsonDateValueProcessor() {
        super();
    }
    public JsonDateValueProcessor(String format) {
        super();
        this.format = format;
    }
    @Override
    public Object processArrayValue(Object paramObject, JsonConfig jsonConfig) {
        return process(paramObject);
    }

    @Override
    public Object processObjectValue(String s, Object paramObject, JsonConfig jsonConfig) {
        return process(paramObject);
    }

    private Object process(Object value) {
        if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }
}
