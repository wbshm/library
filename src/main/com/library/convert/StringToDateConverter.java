package main.com.library.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangrq
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String o) {
        if (StringUtils.isEmpty(o)) {
            throw new NullPointerException("输入的字符串不正确");
        }
        Date date;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(o);
        } catch (ParseException e) {
            throw new RuntimeException("输入的Date格式不正确yyyy-MM-dd:" + o);
        }
        return date;
    }
}
