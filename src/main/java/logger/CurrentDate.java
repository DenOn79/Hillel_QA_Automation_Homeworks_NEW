package logger;

import java.util.Date;

public class CurrentDate {
    public static String getCurrentDate() {
        Date currentDate = new Date();
        return currentDate.toString();
    }
}
