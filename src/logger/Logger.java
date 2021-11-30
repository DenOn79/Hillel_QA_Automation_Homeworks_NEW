package logger;

public class Logger {
    public static void logMessage(LogLevels level, String message) {
        System.out.println(CurrentDate.getCurrentDate());
        System.out.println(level.getLevel());
        System.out.println(message);
    }
}
