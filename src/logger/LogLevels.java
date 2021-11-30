package logger;

public enum LogLevels {
    INFO(Colors.ANSI_GREEN + "Info" + Colors.ANSI_RESET),
    DEBUG(Colors.ANSI_BLUE + "Debug" + Colors.ANSI_RESET),
    WARN(Colors.ANSI_YELLOW + "Warn" + Colors.ANSI_RESET),
    ERROR(Colors.ANSI_RED + "Error" + Colors.ANSI_RESET);

    private String level;

    LogLevels(String level) {

        this.level = level;
    }

    public String getLevel() {

        return level;
    }
}
