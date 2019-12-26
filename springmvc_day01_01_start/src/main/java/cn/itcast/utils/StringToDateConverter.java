package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:把字符串转换成日期
 * @author: wll
 * @create: 2019-12-24 17:34
 **/
public class StringToDateConverter implements Converter<String, Date>{

    /**
     * @param s 传入进来字符串
     * @return
     */
    @Override
    public Date convert(String s) {
        if (s ==null){
            throw new RuntimeException("请你传入参数");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转换日期
        try {
           return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换错误");
        }
    }
}
