package com.zhengshr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	//@Override
	public Date convert(String arg0) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return df.parse(arg0);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
