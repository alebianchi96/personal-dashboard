package com.it.personaldashboard.utils;

public class DateUtils {
    
    private DateUtils(){}

    public static Integer getIndexByMonth(String month) {
        if("Gennaio".equalsIgnoreCase(month)) { return 1; }
        else if("Febbraio".equalsIgnoreCase(month)) { return 2; }
        else if("Marzo".equalsIgnoreCase(month)) { return 3; }
        else if("Aprile".equalsIgnoreCase(month)) { return 4; }
        else if("Maggio".equalsIgnoreCase(month)) { return 5; }
        else if("Giugno".equalsIgnoreCase(month)) { return 6; }
        else if("Luglio".equalsIgnoreCase(month)) { return 7; }
        else if("Agosto".equalsIgnoreCase(month)) { return 8; }
        else if("Settembre".equalsIgnoreCase(month)) { return 9; }
        else if("Ottobre".equalsIgnoreCase(month)) { return 10; }
        else if("Novembre".equalsIgnoreCase(month)) { return 11; }
        else if("Dicembre".equalsIgnoreCase(month)) { return 12; }
        return 0;
    }

}
