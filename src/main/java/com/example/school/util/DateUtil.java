package com.example.school.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
    public static Date localDateToDate(LocalDate localDate){
        if (localDate == null) throw new NullPointerException();
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
