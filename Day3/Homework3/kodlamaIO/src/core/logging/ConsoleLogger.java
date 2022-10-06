package core.logging;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("Logged to console : " + data);
    }
}
