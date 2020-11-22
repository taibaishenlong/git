package com.wangchao.day1022.param1.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    //进行数据类型转换的方法
    public Date convert(String source) {
        //判断
        if(source == null){
            throw new RuntimeException("参数不能为空");
        }
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //解析字符串
            Date date = dateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException("类型转换错误");
        }
    }
}
